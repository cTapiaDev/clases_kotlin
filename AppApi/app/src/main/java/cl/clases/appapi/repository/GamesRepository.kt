package cl.clases.appapi.repository

import cl.clases.appapi.data.ApiGames
import cl.clases.appapi.model.GameList
import cl.clases.appapi.model.GamesModel
import cl.clases.appapi.model.SingleGameModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class GamesRepository @Inject constructor(private val apiGames: ApiGames) {

    suspend fun getGames(): List<GameList>? {
        val response = apiGames.getGames()
        if (response.isSuccessful) {
            return response.body()?.results
        }
        return null
    }

    suspend fun getGameById(id: Int): SingleGameModel? {
        val response = apiGames.getGameById(id)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

    suspend fun getGameByName(name: String): SingleGameModel? {
        val response = apiGames.getGameById(name)
        if (response.isSuccessful) {
            return response.body()
        }
        return null
    }

    suspend fun getGamesPaging(page: Int, pageSize: Int): GamesModel {

        delay(3000L)

        return apiGames.getGamesPaging(page, pageSize)
    }


}