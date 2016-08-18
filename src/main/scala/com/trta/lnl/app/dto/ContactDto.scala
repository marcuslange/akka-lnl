package com.trta.lnl.app.dto

/**
  * Created by mlange on 8/17/16.
  */
case class ContactSummaryDto(id:String, firstName:String, lastName:String)

case class ContactDto(
  id:String,
  firstName:String,
  middleName:Option[String],
  lastName:String,
  streetOne:Option[String],
  streetTwo:Option[String],
  city:Option[String],
  state:Option[String],
  postalCode:Option[String],
  phone:Option[String],
  email:Option[String]
)
