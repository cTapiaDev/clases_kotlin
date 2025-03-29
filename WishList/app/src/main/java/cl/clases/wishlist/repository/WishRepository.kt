package cl.clases.wishlist.repository

import cl.clases.wishlist.model.Wish
import cl.clases.wishlist.room.WishDao
import kotlinx.coroutines.flow.Flow

class WishRepository(private val wishDao: WishDao) {

    suspend fun addWish(wish: Wish) = wishDao.addWish(wish)

    suspend fun updateAWish(wish: Wish) = wishDao.updateWish(wish)

    suspend fun deleteAWish(wish: Wish) = wishDao.deleteWish(wish)

    fun getWishes(): Flow<List<Wish>> {
        return wishDao.getAllWishes()
    }

    fun getAWishById(id: Long): Flow<Wish> {
        return wishDao.getAWishById(id)
    }

}