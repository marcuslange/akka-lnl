package com.trta.lnl.app

import com.trta.lnl.app.assembler.ContactAssembler
import com.trta.lnl.domain.contact.ContactComponent
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by mlange on 8/17/16.
  */
class ContactService {
  this:ContactComponent =>

  val contactAssembler = ContactAssembler

  def getAll = {
    for (contacts <- contactRepository.findAll())
      yield contactAssembler.toDtos(contacts)
  }

}
