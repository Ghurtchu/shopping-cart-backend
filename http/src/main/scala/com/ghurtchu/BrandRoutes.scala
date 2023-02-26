package com.ghurtchu

import cats.Monad
import org.http4s._
import org.http4s.circe.CirceEntityEncoder._
import org.http4s.dsl.Http4sDsl
import org.http4s.server.Router

case class BrandRoutes[F[_]: Monad](
  brands: Brands[F],
) extends Http4sDsl[F] {

  val prefixPath = "/brands"

  val httpRoutes: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root => Ok(brands.findAll)
  }

  val routes: HttpRoutes[F] = Router(
    prefixPath -> httpRoutes
  )
}
