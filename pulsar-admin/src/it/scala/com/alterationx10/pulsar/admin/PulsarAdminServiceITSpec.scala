package com.alterationx10.pulsar.admin

import zio._
import zio.test._

object PulsarAdminServiceITSpec extends DefaultRunnableSpec {

  def spec: ZSpec[TestEnvironment, Any] = suite("PulsarAdminServiceITSpec")(
    suite("tests...") {
      test("...should be implemented") {
        for {
          _ <- ZIO.unit
        } yield assertCompletes
      }
    }
  )

}
