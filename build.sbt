name := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.10"

val circeVersion = "0.14.1"
val json4sVersion = "4.0.6"
val scoptVersion = "4.1.0"

lazy val app = (project in file("app"))
  .settings(
     mainClass := Some("Main")
  )

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "org.json4s" %% "json4s-jackson" % json4sVersion,
  "org.json4s" %% "json4s-core" % json4sVersion,
  "com.github.scopt" %% "scopt" % "4.1.0"
)

