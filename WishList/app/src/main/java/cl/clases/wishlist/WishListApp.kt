package cl.clases.wishlist

import android.app.Application
import cl.clases.wishlist.room.Graph

class WishListApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}