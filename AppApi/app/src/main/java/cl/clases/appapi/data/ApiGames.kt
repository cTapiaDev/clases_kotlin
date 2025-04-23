package cl.clases.appapi.data

import cl.clases.appapi.model.GamesModel
import cl.clases.appapi.model.SingleGameModel
import cl.clases.appapi.util.Constants.Companion.API_KEY
import cl.clases.appapi.util.Constants.Companion.ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiGames {

    @GET(ENDPOINT + API_KEY)
    suspend fun getGames(): Response<GamesModel>

    @GET("$ENDPOINT/{id}$API_KEY")
    suspend fun getGameById(@Path(value = "id") id: Int): Response<SingleGameModel>

    @GET("$ENDPOINT/{name}$API_KEY")
    suspend fun getGameById(@Path(value = "name") id: String): Response<SingleGameModel>

    @GET(ENDPOINT + API_KEY)
    suspend fun getGamesPaging(@Query("page") page: Int, @Query("page_size") pageSize: Int): GamesModel
}