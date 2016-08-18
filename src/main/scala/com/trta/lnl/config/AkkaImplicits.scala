package com.trta.lnl.config

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

/**
  * Created by mlange on 8/17/16.
  */
trait AkkaImplicits {
  implicit val system = ActorSystem("akka-lnl")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher
}
