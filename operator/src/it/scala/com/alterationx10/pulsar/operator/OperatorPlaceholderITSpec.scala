package com.alterationx10.pulsar.operator

import zio.*
import zio.test.*

object OperatorPlaceholderITSpec extends DefaultRunnableSpec {

  def spec: ZSpec[TestEnvironment, Any] = suite("Operator OperatorPlaceholderITSpec")(
    suite("tests...") {
      test("...should be implemented") {
        for {
          _ <- ZIO.unit
        } yield assertCompletes
      }
    }
  )

}
