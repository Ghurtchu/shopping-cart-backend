package com.ghurtchu

final case class Checkout[F[_]](
  paymentClient: PaymentClient[F],
  shoppingCart: ShoppingCart[F],
  orders: Orders[F],
)
