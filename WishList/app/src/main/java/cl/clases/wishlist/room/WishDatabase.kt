package cl.clases.wishlist.room

import androidx.room.Database
import androidx.room.RoomDatabase
import cl.clases.wishlist.model.Wish

@Database(
    entities = [Wish::class],
    version = 1
)
abstract class WishDatabase: RoomDatabase() {
    abstract fun wishDao(): WishDao
}