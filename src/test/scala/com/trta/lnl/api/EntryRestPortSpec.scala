package com.trta.lnl.api

import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.trta.lnl.port.primary.rest.EntryRestPort
import org.scalatest.{Matchers, WordSpec}


/**
  * Created by mlange on 8/17/16.
  */
class EntryRestPortSpec extends WordSpec
  with Matchers
  with ScalatestRouteTest
  with EntryRestPort {

  "The entry service" should {
    "return HAL content describing available resources" in {
      Get() ~> entryRoutes ~> check {
        val response = responseAs[String]
        status shouldEqual OK
        response should include("self")
      }
    }
  }
}
