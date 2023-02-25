package com.ghurtchu

import com.ghurtchu.order.OrderId
import com.ghurtchu.user.UserId

trait Orders[F[_]] {
  def get(
    userId: UserId,
    orderId: OrderId,
  ): Unit
}
