import sbt._

object Dependencies {

  lazy val DomainDependencies: Seq[ModuleID] = Seq(newtype)

  val newtype  = "io.estatico" %% "newtype" % "0.4.4"

}
