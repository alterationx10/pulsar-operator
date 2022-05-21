package com.alterationx10.pulsar.operator

import zio._
import zio.test._

object OperatorPlaceholderITSpec extends DefaultRunnableSpec {

  def spec: ZSpec[TestEnvironment, Any] = suite("OperatorPlaceholderITSpec")(
    suite("tests...") {
      test("...should be implemented") {
        for {
          _ <- ZIO.unit
        } yield assertCompletes
      }
    }
  )

}
