package cl.clases.appapi.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import cl.clases.appapi.model.GameList
import cl.clases.appapi.repository.GamesRepository

class GamesDataSource(private val repository: GamesRepository): PagingSource<Int, GameList>() {
    override fun getRefreshKey(state: PagingState<Int, GameList>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GameList> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = repository.getGamesPaging(nextPageNumber, 3)
            LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = if (response.results.isNotEmpty()) nextPageNumber + 1 else null
            )
        } catch (e:Exception) {
            LoadResult.Error(e)
        }
    }

}