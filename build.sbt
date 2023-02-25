ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.5"

val org = "com.ghurtchu"

lazy val root = (project in file("."))
  .settings(
    name := "Shopping Cart Backend",
    normalizedName := normalizeName(name.value),
    Compile / mainClass := Some("Main")
  ).dependsOn(boot)
  .aggregate()

lazy val boot = project
  .settings(
    normalizedName := normalizeName(name.value),
    organization := org,
  )
  .dependsOn(shop, http)

lazy val domain = project
  .settings(
    normalizedName := normalizeName(name.value),
    scalacOptions ++= List("-Ymacro-annotations", "-Yrangepos", "-Wconf:cat=unused:info"),
    organization := org,
    libraryDependencies ++= Dependencies.Domain.dependencies
  )

lazy val http = project.dependsOn(shop)

lazy val iam = project

lazy val persistence = project

lazy val shop = project.dependsOn(domain, persistence)

def normalizeName(name: String): String = name.toLowerCase.replace(" ", "-")
