package cl.clases.wishlist.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import cl.clases.wishlist.model.Wish
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    @Insert
    abstract suspend fun addWish(wishEntity: Wish)

    @Update
    abstract suspend fun updateWish(wishEntity: Wish)

    @Delete
    abstract suspend fun deleteWish(wishEntity: Wish)

    @Query("SELECT * FROM `wish-table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Query("SELECT * FROM `wish-table` WHERE id = :id")
    abstract fun getAWishById(id: Long): Flow<Wish>

}