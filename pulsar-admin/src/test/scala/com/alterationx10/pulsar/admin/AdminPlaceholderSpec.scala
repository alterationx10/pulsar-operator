package com.alterationx10.pulsar.admin

import zio.*
import zio.test.*

object AdminPlaceholderSpec extends DefaultRunnableSpec {

  def spec = suite("Admin AdminPlaceholderITSpec")(
    suite("tests...") {
      test("...should be implemented") {
        for {
          _ <- ZIO.unit
        } yield assertCompletes
      }
    }
  )

}
