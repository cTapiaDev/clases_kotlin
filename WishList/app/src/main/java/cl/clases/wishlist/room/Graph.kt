package cl.clases.wishlist.room

import android.content.Context
import androidx.room.Room
import cl.clases.wishlist.repository.WishRepository

object Graph {
    lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(
            context,
            WishDatabase::class.java,
            "wishList.db"
        ).build()
    }

}