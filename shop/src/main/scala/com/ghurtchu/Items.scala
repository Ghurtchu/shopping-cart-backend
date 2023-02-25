package com.ghurtchu

import brand.BrandName
import item._

trait Items[F[_]] {
  def findAll: F[List[Item]]
  def findByBrandName(brandName: BrandName): F[List[Item]]
  def findByItemId(itemId: ItemId): F[Option[Item]]
  def create(item: CreateItem): F[ItemId]
  def update(item: UpdateItem): F[Unit]
}
