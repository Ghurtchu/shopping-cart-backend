
trait Brands[F[_]] {
  def findAll: F[List[Any]] // Brand
  def create(name: Any): F[Any] // BrandName, BrandId
}
