ThisBuild / scalaVersion := "2.13.11"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "ua.semer"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "vigil_challenge",
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % "3.2.16",
      "org.scalatest" %% "scalatest" % "3.2.16" % "test"
    )
  )
