import sbt._

object Dependencies {

  type ModuleIDs = Seq[ModuleID]

  import Miscellaneous._

  object Domain {
    lazy val dependencies: ModuleIDs = Seq(newtype, squants)
  }

  object HealthCheck {
    lazy val dependencies: ModuleIDs = Seq(newtype, monocleCore) ++ Circe.circeStack ++ Derevo.derevoStack
  }

  object Shop {
    lazy val dependencies: ModuleIDs = Cats.catsStack
  }

  object Http {
    lazy val dependencies: ModuleIDs = Http4s.http4sStack
  }

  object Versions {
    val newtype = "0.4.4"
    val squants = "1.8.3"
    val monocle = "3.1.0"
    val circe = "0.14.2"
    val derevo = "0.13.0"
    val cats = "2.7.0"
    val catsEffect = "3.3.12"
    val catsRetry = "3.1.0"
    val log4cats = "2.3.1"
    val http4s = "0.23.1"
    val http4sJwtAuth = "1.0.0"
  }

  object Cats {
    val cats = "org.typelevel"         %% "cats-core"      % Versions.cats
    val catsEffect = "org.typelevel"   %% "cats-effect"    % Versions.catsEffect
    val catsRetry = "com.github.cb372" %% "cats-retry"     % Versions.catsRetry
    val log4cats = "org.typelevel"     %% "log4cats-slf4j" % Versions.log4cats

    val catsStack: ModuleIDs = Seq(cats, catsEffect, catsRetry, log4cats)
  }

  object Http4s {
    def http4s(artifact: String): ModuleID = "org.http4s" %% s"http4s-$artifact" % Versions.http4s

    val http4sDsl = http4s("dsl")
    val http4sServer = http4s("ember-server")
    val http4sClient = http4s("ember-client")
    val http4sCirce = http4s("circe")

    val http4sJwtAuth = "dev.profunktor" %% "http4s-jwt-auth" % Versions.http4sJwtAuth

    val http4sStack: ModuleIDs = Seq(http4sDsl, http4sServer, http4sClient, http4sCirce, http4sJwtAuth)
  }

  object Circe {
    def circe(artifact: String): ModuleID = "io.circe" %% s"circe-$artifact" % Versions.circe

    val circeCore = circe("core")
    val circeGeneric = circe("generic")
    val circeParser = circe("parser")
    val circeRefined = circe("refined")

    val circeStack: ModuleIDs = Seq(circeCore, circeGeneric, circeParser, circeRefined)
  }

  object Derevo {
    def derevo(artifact: String): ModuleID = "tf.tofu" %% s"derevo-$artifact" % Versions.derevo

    val derevoCore = derevo("core")
    val derevoCats = derevo("cats")
    val derevoCirce = derevo("circe-magnolia")

    val derevoStack: ModuleIDs = Seq(derevoCore, derevoCats, derevoCirce)
  }

  object Miscellaneous {
    val newtype = "io.estatico"    %% "newtype"      % Versions.newtype
    val squants = "org.typelevel"  %% "squants"      % Versions.squants
    val monocleCore = "dev.optics" %% "monocle-core" % Versions.monocle

    val all = Seq(newtype, squants, monocleCore)
  }

}
