package com.ghurtchu

import io.estatico.newtype.macros.newtype

import java.util.UUID

object category {

  @newtype final case class CategoryId(value: UUID)
  @newtype final case class CategoryName(value: String)

  final case class Category(uuid: CategoryId, name: CategoryName)

}
