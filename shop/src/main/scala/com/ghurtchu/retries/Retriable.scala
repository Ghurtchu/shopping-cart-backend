package com.ghurtchu.retries

sealed trait Retriable

object Retriable {
  case object Order   extends Retriable
  case object Payment extends Retriable
}
