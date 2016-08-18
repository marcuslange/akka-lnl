package com.trta.lnl.domain.contact

import com.trta.lnl.domain.ContactRepository
import com.trta.lnl.port.secondary.persistence.stub.ContactRepositoryStub

/**
  * Created by mlange on 8/17/16.
  */
trait ContactComponent {
  protected lazy val contactRepository:ContactRepository = ContactRepositoryStub
}
