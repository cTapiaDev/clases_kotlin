package cl.clases.appapi.viewModel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import cl.clases.appapi.data.GamesDataSource
import cl.clases.appapi.model.GameList
import cl.clases.appapi.repository.GamesRepository
import cl.clases.appapi.state.GameState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(private val repository: GamesRepository) : ViewModel() {

    private val _games = MutableStateFlow<List<GameList>>(emptyList())
    val games = _games.asStateFlow()

    var state by mutableStateOf(GameState())
        private set

    init {
        fetchGames()
    }

    private fun fetchGames() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getGames()
            _games.value = result ?: emptyList()
        }
    }

    fun getGameById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getGameById(id)
            state = state.copy(
                name = result?.name ?: "",
                description_raw = result?.description_raw ?: "",
                metacritic = result?.metacritic ?: 0,
                website = result?.website ?: "",
                background_image_additional = result?.background_image_additional ?: ""
            )
        }
    }

    fun getGameByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.getGameByName(name)
            state = state.copy(
                name = result?.name ?: "",
                description_raw = result?.description_raw ?: "",
                metacritic = result?.metacritic ?: 0,
                website = result?.website ?: "",
                background_image_additional = result?.background_image_additional ?: ""
            )
        }
    }

    fun clean() {
        state = state.copy(
            name = "",
            description_raw = "",
            metacritic = 0,
            website = "",
            background_image_additional = ""
        )
    }

    val gamesPage = Pager(PagingConfig(pageSize = 3)) {
        GamesDataSource(repository)
    }.flow.cachedIn(viewModelScope)

}