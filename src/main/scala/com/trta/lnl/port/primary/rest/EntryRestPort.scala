package com.trta.lnl.port.primary.rest

import akka.http.rest.hal.{Link, ResourceBuilder}
import akka.http.scaladsl.server.Directives._
import spray.json.DefaultJsonProtocol
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._

/**
  * Created by mlange on 8/17/16.
  */
trait EntryRestPort extends DefaultJsonProtocol {
  private val links = Map(
    "self" -> Link(href = "", title = Some("API Entry"))
  )

  val entryRoutes = path("") {
    get {
      complete(ResourceBuilder(withLinks = Some(links)).build())
    }
  }

}
