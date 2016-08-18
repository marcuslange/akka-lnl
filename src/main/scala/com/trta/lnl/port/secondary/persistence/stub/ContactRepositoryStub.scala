package com.trta.lnl.port.secondary.persistence.stub

import com.trta.lnl.domain._

import scala.collection.mutable
import scala.concurrent.Future

/**
  * Created by mlange on 8/17/16.
  */
object ContactRepositoryStub extends ContactRepository {

  var contacts = mutable.MutableList[Contact] (
    Contact(
      "f84f5c2b-5ef8-4ff3-a055-a5f51144fda1",
      Name("Marcus", Some("Keith"), "Lange"),
      None,
      None,
      None
    ),
    Contact(
      "9226f667-ecd6-4513-928c-8ac4a3426909",
      Name("Tom", None, "McGraw"),
      Some(Address("2395 Midway Rd", Some("CN134"), "Carrollton", Some("TX"), "75006")),
      Some(Phone("1", "972", "250", "7214")),
      Some(Email("tom.mcgraw", "thomsonreuters.com"))
    )
  )

  def findAll(): Future[Traversable[Contact]] = Future.successful(contacts)
  def findById(id: String): Future[Option[Contact]] = Future.successful(contacts.find(c => c.id == id))
  def save(aggregateRoot: Contact): Unit = contacts += aggregateRoot
  def delete(aggregateRoot: Contact): Unit = contacts = contacts.filterNot(c => c.id == aggregateRoot.id)
}
