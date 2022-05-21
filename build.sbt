ThisBuild / organization := "com.alterationx10"
ThisBuild / scalaVersion := "2.13.8" //3.1.2"
ThisBuild / version      := "0.0.0-SNAPSHOT"

lazy val root = (project
  .in(file(".")))
  .settings(
    name            := "pulsar-operator",
    publishArtifact := false
  )
  .aggregate(operator, pulsarAdmin)

lazy val operator = (project
  .in(file("operator")))
  .configs(IntegrationTest)
  .settings(
    name := "pulsar.operator",
    Defaults.itSettings,
    libraryDependencies ++= Dependencies.operatorDependencies,
    testFrameworks += Dependencies.testFrameworks
  )

lazy val pulsarAdmin = (project
  .in(file("pulsar-admin")))
  .configs(IntegrationTest)
  .settings(
    name := "pulsar.admin",
    Defaults.itSettings,
    libraryDependencies ++= Dependencies.adminClientDependencies,
    testFrameworks += Dependencies.testFrameworks
  )
