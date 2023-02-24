ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.5"

lazy val root = (project in file("."))
  .settings(
    name := "Shopping Cart Backend",
    normalizedName := normalizeName(name.value),
    Compile / mainClass := Some("Main")
  ).dependsOn(boot)

lazy val boot = project
  .settings(
    normalizedName := normalizeName(name.value),
  )


def normalizeName(name: String): String = name.toLowerCase.replace(" ", "-")
