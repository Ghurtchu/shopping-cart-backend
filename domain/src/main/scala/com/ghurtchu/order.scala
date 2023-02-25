package com.ghurtchu

import com.ghurtchu.cart.Quantity
import com.ghurtchu.item.ItemId
import com.ghurtchu.payment.PaymentId
import io.estatico.newtype.macros.newtype
import squants.market.Money

import java.util.UUID

object order {

  @newtype final case class OrderId(uuid: UUID)

  final case class Order(
    id: OrderId,
    pid: PaymentId,
    items: Map[ItemId, Quantity],
    total: Money,
  )

}
