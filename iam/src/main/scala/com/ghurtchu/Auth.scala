package com.ghurtchu

import com.ghurtchu.user._

trait Auth[F[_]] {
  def findUser(token: JwtToken): F[Option[User]]
  def newUser(username: UserName, password: Password): F[JwtToken]
}

object Auth {

}
