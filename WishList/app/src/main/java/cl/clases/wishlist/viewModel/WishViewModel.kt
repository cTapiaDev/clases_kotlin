package cl.clases.wishlist.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.clases.wishlist.model.Wish
import cl.clases.wishlist.repository.WishRepository
import cl.clases.wishlist.room.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
): ViewModel() {

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAllWishes = wishRepository.getWishes()
        }
    }

    fun addWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.addWish(wish)
        }
    }

    fun updateWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.updateAWish(wish)
        }
    }

    fun deleteWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            wishRepository.deleteAWish(wish)
        }
    }

    fun getAWishById(id: Long): Flow<Wish> {
        return wishRepository.getAWishById(id)
    }
}