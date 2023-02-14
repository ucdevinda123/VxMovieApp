package com.spore.vxmoviesapp.data.repository.watchlist

import com.spore.vxmoviesapp.data.offline.entity.MyList
import kotlinx.coroutines.flow.Flow

interface VxLocalWatchListRepository {

    suspend fun addToWatchList(myList: MyList)
    fun getFullWatchList() : Flow<List<MyList>>
    suspend fun getExistIdFromWatchList(mediaId: Long): Long
    suspend fun removeFromMyList(mediaId: Long)
}