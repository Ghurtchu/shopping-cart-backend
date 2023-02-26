package com.ghurtchu.retries

import cats.effect.Temporal
import org.typelevel.log4cats.Logger
import retry._

trait Retry[F[_]] {
  def retry[A](retryPolicy: RetryPolicy[F], retriable: Retriable)(fa: F[A]): F[A]

}

object Retry {
  def apply[F[_]: Retry]: Retry[F] = implicitly

  implicit def forLoggerTemporal[F[_]: Logger: Temporal]: Retry[F] = new Retry[F] {
    override def retry[A](retryPolicy: RetryPolicy[F], retriable: Retriable)(fa: F[A]): F[A] = {
      def onError(t: Throwable, details: RetryDetails): F[Unit] =
        details match {
          case RetryDetails.GivingUp(totalRetries, _) =>
            Logger[F].error(s"Giving up $retriable with ${t.getMessage} after $totalRetries times")
          case RetryDetails.WillDelayAndRetry(_, retriesSoFar, _) =>
            Logger[F].error(s"Failed on $retriable. We retried $retriesSoFar times.")
        }

      retryingOnAllErrors[A](retryPolicy, onError)(fa)
    }

  }
}
