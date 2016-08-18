package com.trta.lnl.app.assembler

import com.trta.lnl.app.dto.{ContactDto, ContactSummaryDto}
import com.trta.lnl.domain.Contact

/**
  * Created by mlange on 8/17/16.
  */
object ContactAssembler {

  def toDtos(contacts: Traversable[Contact]) = {
    contacts.map(c => ContactSummaryDto(c.id, c.name.first, c.name.last)).toList
  }

  def toDto(contact:Contact) = {
    val address = mapAddress(contact)
    val phone = mapPhone(contact)
    val email = mapEmail(contact)

    ContactDto(
      contact.id,
      contact.name.first,
      contact.name.middle,
      contact.name.last,
      address._1,
      address._2,
      address._3,
      address._4,
      address._5,
      phone,
      email
    )
  }

  private def mapAddress(contact:Contact) = {
    contact.address match {
      case Some(a) => (Some(a.streetOne), a.streetTwo, Some(a.city), a.state, Some(a.postalCode))
      case _ => (None, None, None, None, None)
    }
  }

  private def mapPhone(contact:Contact) = {
    contact.phone match {
      case Some(p) => Some(s"${p.countyCode} ${p.areaCode} ${p.prefix} ${p.suffix}")
      case _ => None
    }
  }

  private def mapEmail(contact:Contact) = {
    contact.email match {
      case Some(e) => Some(s"${e.address}@${e.domain}")
      case _ => None
    }
  }

}
