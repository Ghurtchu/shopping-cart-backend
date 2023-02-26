package com.ghurtchu

import cats.MonadThrow
import cats.syntax.flatMap._
import cats.syntax.functor._
import cats.syntax.applicativeError._
import cats.data.NonEmptyList
import com.ghurtchu.Checkout.EmptyCartError
import com.ghurtchu.order.OrderId
import com.ghurtchu.payment.Payment
import com.ghurtchu.user.UserId

import scala.util.control.NoStackTrace

final case class Checkout[F[_]: MonadThrow](
  paymentClient: PaymentClient[F],
  shoppingCart: ShoppingCart[F],
  orders: Orders[F],
) {

  def process(userId: UserId, card: Any): F[OrderId] =
    for {
      cart <- shoppingCart.get(userId)
      items <- ensureNonEmpty(cart.items)
      pid <- paymentClient.process(Payment(userId, cart.total, card))
      oid <- orders.create(userId, pid, items, cart.total)
      _ <- shoppingCart.delete(userId).attempt.void
    } yield oid

  private def ensureNonEmpty[A](as: List[A]): F[NonEmptyList[A]] =
    MonadThrow[F].fromOption(
      NonEmptyList.fromList(as),
      EmptyCartError,
    )

  private def retry[F[_], A](fa: F[A]): F[A] =


}

object Checkout {
  final case object EmptyCartError extends NoStackTrace
}
