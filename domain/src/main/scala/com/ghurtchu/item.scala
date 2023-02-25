package com.ghurtchu

import com.ghurtchu.brand.Brand
import com.ghurtchu.category.Category
import io.estatico.newtype.macros.newtype

import java.util.UUID

object item {

  @newtype final case class ItemId(value: UUID)
  @newtype final case class ItemName(value: String)
  @newtype final case class ItemDescription(value: String)

  final case class Item(
    uuid: ItemId,
    name: ItemName,
    description: ItemDescription,
    price: BigDecimal,
    brand: Brand,
    category: Category,
  )
}
