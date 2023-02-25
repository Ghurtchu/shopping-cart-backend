package com.ghurtchu

import derevo.circe.magnolia.encoder
import derevo.derive
import io.circe.Encoder
import io.estatico.newtype.macros.newtype
import monocle.Iso

object appstatus {

  sealed trait Status

  object Status {
    case object Alive extends Status
    case object Dead extends Status

    val iso: Iso[Status, Boolean] = Iso[Status, Boolean] {
      case Alive => true
      case Dead  => false
    }(if (_) Alive else Dead)

    implicit val jsonEncoder: Encoder[Status] =
      Encoder.forProduct1("status")(_.toString)

  }

  @derive(encoder)
  @newtype
  final case class RedisStatus(value: Status)

  @derive(encoder)
  @newtype
  final case class PostgresStatus(value: Status)

  @derive(encoder)
  final case class AppStatus(
    redis: RedisStatus,
    postgres: PostgresStatus,
  )

}
