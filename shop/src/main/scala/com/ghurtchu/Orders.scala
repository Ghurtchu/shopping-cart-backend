package com.ghurtchu

import cats.data.NonEmptyList
import com.ghurtchu.cart.CartItem
import com.ghurtchu.order.{Order, OrderId}
import com.ghurtchu.payment.PaymentId
import com.ghurtchu.user.{User, UserId}
import squants.market.Money

trait Orders[F[_]] {
  def get(
    userId: UserId,
    orderId: OrderId,
  ): F[Option[User]]
  def findByUserId(userId: UserId): F[List[Order]]
  def create(
    userId: UserId,
    paymentId: PaymentId,
    items: NonEmptyList[CartItem],
    total: Money,
  ): F[OrderId]
}
