package com.ghurtchu

import com.ghurtchu.payment.{Payment, PaymentId}

trait PaymentClient[F[_]] {
  def process(payment: Payment): F[PaymentId]
}
