package com.ghurtchu

import com.ghurtchu.appstatus.AppStatus

trait HealthCheck[F[_]] {
  def status: F[AppStatus]
}
