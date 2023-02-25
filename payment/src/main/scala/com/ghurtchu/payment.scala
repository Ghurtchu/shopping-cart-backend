package com.ghurtchu

import com.ghurtchu.user.UserId
import io.estatico.newtype.macros.newtype
import squants.market.Money

object payment {

  @newtype final case class PaymentId(value: String)

  final case class Payment(
    id: UserId,
    total: Money,
    card: Any, // Card here
  )
}
