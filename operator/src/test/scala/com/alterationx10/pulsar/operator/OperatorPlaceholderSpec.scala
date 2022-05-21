package com.alterationx10.pulsar.operator
import zio._
import zio.test._

object OperatorPlaceholderSpec extends DefaultRunnableSpec {

  def spec: ZSpec[TestEnvironment, Any] = suite("OperatorPlaceholderSpec")(
    suite("tests...") {
      test("...should be implemented") {
        for {
          _ <- ZIO.unit
        } yield assertCompletes
      }
    }
  )

}
