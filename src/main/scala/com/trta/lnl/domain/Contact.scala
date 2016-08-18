package com.trta.lnl.domain

import com.trta.lnl.common.domain.{AggregateRoot, Repository}

/**
  * Created by mlange on 8/17/16.
  */

trait ContactRepository extends Repository[Contact]

case class Contact(
  id:String,
  name:Name,
  address:Option[Address],
  phone:Option[Phone],
  email:Option[Email]
) extends AggregateRoot

case class Name(
 first:String,
 middle:Option[String],
 last:String
)

case class Address(
  streetOne:String,
  streetTwo:Option[String] = None,
  city:String,
  state:Option[String] = None,
  postalCode:String
)

case class Phone(
  countyCode:String,
  areaCode:String,
  prefix:String,
  suffix:String
)

case class Email(
  address:String,
  domain:String
)