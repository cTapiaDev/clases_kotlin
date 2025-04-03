package cl.clases.wishlist.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.clases.wishlist.model.Wish
import cl.clases.wishlist.repository.WishRepository
import cl.clases.wishlist.room.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class WishViewModel(
    private val wishRepository: WishRepository = Graph.wishRepository
): ViewModel() {

    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    private val _snackMessage = MutableSharedFlow<String>()
    val snackMessage: SharedFlow<String> = _snackMessage.asSharedFlow()

    fun saveWish(id: Long, onSuccess: () -> Unit) {
        viewModelScope.launch {
            if (wishTitleState.isNotEmpty() && wishDescriptionState.isNotEmpty()) {
                if (id != 0L) {
                    updateWish(
                        Wish(
                            id = id,
                            title = wishTitleState.trim(),
                            description = wishDescriptionState.trim()
                        )
                    )
                    _snackMessage.emit("Modificando elemento...")
                } else {
                    addWish(
                        Wish(
                            title = wishTitleState.trim(),
                            description = wishDescriptionState.trim()
                        )
                    )
                    _snackMessage.emit("Guardando elemento...")
                }
                onSuccess()
            } else {
                _snackMessage.emit("Debes ingresar un nuevo elemento.")
            }
        }
    }

    fun loadWish(id: Long) {
        if (id != 0L) {
            viewModelScope.launch {
                wishRepository.getAWishById(id).collect { wish ->
                    wishTitleState = wish.title
                    wishDescriptionState = wish.description
                }
            }
        } else {
            wishTitleState = ""
            wishDescriptionState = ""
        }
    }


    fun onChangedTitle(new: String) {
        wishTitleState = new
    }

    fun onChangedDescription(new: String) {
        wishDescriptionState = new
    }




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