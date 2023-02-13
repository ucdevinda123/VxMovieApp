package com.spore.vxmoviesapp.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.spore.vxmoviesapp.data.network.RetrofitMovieService
import com.spore.vxmoviesapp.data.network.dto.MovieResponseDto
import com.spore.vxmoviesapp.data.repository.VxMovieQuery
import com.spore.vxmoviesapp.domain.model.Movie
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NowPlayingMoviePagingSource @Inject constructor(
    var vxMovieApi: RetrofitMovieService,
    var searchQuery: String = "",
) : PagingSource<Int, Movie>() {


    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            lateinit var movieResponse: MovieResponseDto
            val nextPage = params.key ?: 1
            movieResponse = vxMovieApi.getNowPlayingMovies(nextPage)

            val data = movieResponse.results.map {
                it.asDomainModel()
            }

            LoadResult.Page(
                data = data,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (movieResponse.results.isEmpty()) null else movieResponse.page + 1
            )

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}