package com.ghurtchu

import com.ghurtchu.item.{Item, ItemId}
import io.estatico.newtype.macros.newtype
import squants.market.Money

object cart {

  @newtype final case class Quantity(value: Int)
  @newtype final case class Cart(items: Map[ItemId, Quantity])

  final case class CartItem(item: Item, quantity: Quantity)
  final case class CartTotal(items: List[CartItem], total: Money)
}
