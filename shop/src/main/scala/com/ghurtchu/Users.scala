package com.ghurtchu

import user._

trait Users[F[_]] {
  def find(username: UserName): F[Option[UserWithPassword]]
  def create(username: UserName, password: EncryptedPassword): F[UserId]
  def login(username: UserName, password: Password): F[JwtToken]
  def logout(token: JwtToken, userName: UserName): F[Unit]
}
