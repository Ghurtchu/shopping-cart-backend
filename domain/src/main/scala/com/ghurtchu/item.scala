package com.ghurtchu

import com.ghurtchu.brand.{Brand, BrandId}
import com.ghurtchu.category.{Category, CategoryId}
import io.estatico.newtype.macros.newtype
import squants.market.Money

import java.util.UUID

object item {

  @newtype final case class ItemId(value: UUID)
  @newtype final case class ItemName(value: String)
  @newtype final case class ItemDescription(value: String)

  final case class Item(
    uuid: ItemId,
    name: ItemName,
    description: ItemDescription,
    price: Money,
    brand: Brand,
    category: Category,
  )

  final case class CreateItem(
    name: ItemName,
    description: ItemDescription,
    price: Money,
    brandId: BrandId,
    categoryId: CategoryId,
  )

  final case class UpdateItem(
    id: ItemId,
    price: Money,
  )
}
