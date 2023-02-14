package com.spore.vxmoviesapp.domain.usecases

import com.spore.vxmoviesapp.data.offline.entity.MyList
import com.spore.vxmoviesapp.data.repository.watchlist.VxLocalWatchListRepository
import com.spore.vxmoviesapp.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WatchListUseCase @Inject constructor(private val watchListRepository: VxLocalWatchListRepository) {

    suspend fun insertToWatchList(movie: Movie) {
        val myListMovie = MyList(movie.id, movie.posterUrl, movie.title)
         watchListRepository.addToWatchList(myListMovie)
    }

    suspend fun removeFromList(mediaId: Long){
        watchListRepository.removeFromMyList(mediaId)
    }

    fun getAllWatchListMovies(): Flow<List<MyList>> {
        return watchListRepository.getFullWatchList()
    }

    suspend fun isExitInTheWatchList(mediaId: Long): Boolean {
        val mediaIdExist = watchListRepository.getExistIdFromWatchList(mediaId)
        if (mediaIdExist > 0) {
            return true
        }
        return false
    }
}