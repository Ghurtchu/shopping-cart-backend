import sbt._

object Dependencies {

  import Miscellaneous._

  object Domain {
    lazy val dependencies: Seq[ModuleID] = Seq(newtype, squants)
  }

  object HealthCheck {
    lazy val dependencies: Seq[ModuleID] = Seq(newtype, monocleCore) ++ Circe.circeStack ++ Derevo.derevoStack
  }

  object Shop {
    lazy val dependencies: Seq[ModuleID] = Cats.catsStack
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
  }

  object Cats {
    val cats = "org.typelevel" %% "cats-core" % Versions.cats
    val catsEffect = "org.typelevel" %% "cats-effect" % Versions.catsEffect
    val catsRetry = "com.github.cb372" %% "cats-retry" % Versions.catsRetry

    val catsStack: Seq[ModuleID] = Seq(cats, catsEffect, catsRetry)
  }

  object Circe {
    def circe(artifact: String): ModuleID = "io.circe" %% s"circe-$artifact" % Versions.circe

    val circeCore = circe("core")
    val circeGeneric = circe("generic")
    val circeParser = circe("parser")
    val circeRefined = circe("refined")

    val circeStack: Seq[ModuleID] = Seq(circeCore, circeGeneric, circeParser, circeRefined)
  }

  object Derevo {
    def derevo(artifact: String): ModuleID = "tf.tofu" %% s"derevo-$artifact" % Versions.derevo

    val derevoCore = derevo("core")
    val derevoCats = derevo("cats")
    val derevoCirce = derevo("circe-magnolia")

    val derevoStack: Seq[ModuleID] = Seq(derevoCore, derevoCats, derevoCirce)
  }

  object Miscellaneous {
    val newtype = "io.estatico"    %% "newtype"      % Versions.newtype
    val squants = "org.typelevel"  %% "squants"      % Versions.squants
    val monocleCore = "dev.optics" %% "monocle-core" % Versions.monocle

    val all = Seq(newtype, squants, monocleCore)
  }

}
