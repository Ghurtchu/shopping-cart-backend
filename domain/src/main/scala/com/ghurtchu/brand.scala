package com.ghurtchu

import io.estatico.newtype.macros.newtype

import java.util.UUID

object brand {

  @newtype final case class BrandId(value: UUID)
  @newtype final case class BrandName(value: String)

  final case class Brand(uuid: BrandId, name: BrandName)
}
