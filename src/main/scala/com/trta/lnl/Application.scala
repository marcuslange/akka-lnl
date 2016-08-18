package com.trta.lnl

import akka.http.rest.hal.HalBrowserService
import com.trta.lnl.config.AkkaImplicits
import com.trta.lnl.port.primary.rest.EntryRestPort
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.Http

/**
  * Created by mlange on 8/17/16.
  */
object Application extends App with AkkaImplicits
  with HalBrowserService
  with EntryRestPort {
  val routes = halBrowserRoutes ~ entryRoutes
  val bindingFuture = Http().bindAndHandle(routes, "localhost", 8080)
}
