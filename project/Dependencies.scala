import sbt._

object Dependencies {

  object Domain {
    val dependencies: Seq[ModuleID] = Seq(newtype)
  }

  object Versions {
    val newtype = "0.4.4"
    val squants = "1.8.3"
  }

  val newtype = "io.estatico"   %% "newtype" % Versions.newtype
  val squants = "org.typelevel" %% "squants" % Versions.squants

}
