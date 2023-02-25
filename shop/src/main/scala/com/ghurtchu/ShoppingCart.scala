package com.ghurtchu

import com.ghurtchu.cart.{Cart, CartTotal, Quantity}
import com.ghurtchu.item.ItemId
import com.ghurtchu.user.UserId

trait ShoppingCart[F[_]] {
  def add(
    userId: UserId,
    itemId: ItemId,
    quantity: Quantity,
  ): F[Unit]
  def get(userId: UserId): F[CartTotal]
  def delete(userId: UserId): F[Unit]
  def removeItem(userId: UserId, itemId: ItemId): F[Unit]
  def update(userId: UserId, cart: Cart): F[Unit]
}
