# shopping-cart-backend
The fully flegdged backend for shopping cart app. Tech used: Scala, Cats/Cats-Effect, http4s, skunk, fs2, Redis, PostgreSQL, circe, monocle, refined, newtype, ciris, derevo.

- GET /brands
- POST /brands
- GET /categories
- POST /categories
- GET /items
- GET /items?brand={name} • POST /items
- PUT /items
- GET /cart
- POST /cart
- PUT /cart
- DELETE /cart/{itemId}
- GET /orders
- GET /orders/{orderId}
- POST /checkout
- POST /auth/users
- POST /auth/login
- POST /auth/logout
