package com.trta.lnl.common.domain

import java.util.UUID

import scala.concurrent.Future

/**
  * Created by mlange on 8/17/16.
  */
trait Repository[T <: AggregateRoot] {
  def nextId = UUID.randomUUID().toString
  def findAll():Future[Traversable[T]]
  def findById(id:String):Future[Option[T]]
  def save(aggregateRoot:T)
  def delete(aggregateRoot:T)
}
