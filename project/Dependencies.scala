import sbt._

object Dependencies {

  private val zioVersion: String    = "2.0.0-RC2"
  private val zioK8sVersion: String = "2.0.0-RC1" // brings in zio 2.0.0-RC2
  private val sttpVersion: String   = "3.5.1"
  private val pulsarVersion: String = "2.9.2"

  private val commonDependencies: Seq[ModuleID] = Seq(
    "dev.zio" %% "zio"          % zioVersion,
    "dev.zio" %% "zio-test"     % zioVersion % "it, test",
    "dev.zio" %% "zio-test-sbt" % zioVersion % "it, test"
  )

  val operatorDependencies: Seq[ModuleID] = Seq(
    "com.coralogix"                 %% "zio-k8s-client"         % zioK8sVersion,
    "com.coralogix"                 %% "zio-k8s-operator"       % zioK8sVersion,
    "com.softwaremill.sttp.client3" %% "httpclient-backend-zio" % sttpVersion,
    "com.softwaremill.sttp.client3" %% "slf4j-backend"          % sttpVersion
  ).map(
    // Conflicting cross-version suffixes in: org.scala-lang.modules:scala-collection-compat
    // org.scala-lang.modules:scala-collection-compat _3, _2.13
    // remove this, brought in from httpclient-backend-zio
    _.exclude("org.scala-lang.modules", "scala-collection-compat_2.13")
  ) ++ commonDependencies

  val adminClientDependencies: Seq[ModuleID] = Seq(
    "org.apache.pulsar" % "pulsar-client-admin" % pulsarVersion
  ) ++ commonDependencies

}
