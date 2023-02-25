package com.ghurtchu

import io.estatico.newtype.macros.newtype

import java.util.UUID

object user {

  @newtype final case class UserId(value: UUID)
  @newtype final case class UserName(value: String)
  @newtype final case class Password(value: String)
  @newtype final case class EncryptedPassword(value: String)

  final case class UserWithPassword(
    id: UserId,
    name: UserName,
    password: EncryptedPassword,
  )

}
