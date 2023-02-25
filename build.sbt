ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.5"

lazy val root = (project in file("."))
  .settings(
    name := "Shopping Cart Backend",
    normalizedName := normalizeName(name.value),
    Compile / mainClass := Some("Main")
  ).dependsOn(boot)
  .aggregate()

lazy val boot = project
  .settings(normalizedName := normalizeName(name.value))
  .dependsOn(shop, http)

lazy val domain = project
  .settings(
    normalizedName := normalizeName(name.value),
    libraryDependencies ++= Dependencies.DomainDependencies
  )

lazy val http = project.dependsOn(shop)

lazy val iam = project

lazy val persistence = project

lazy val shop = project.dependsOn(domain, persistence)


def normalizeName(name: String): String = name.toLowerCase.replace(" ", "-")
