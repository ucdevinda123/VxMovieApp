package com.spore.vxmoviesapp.data.repository.watchlist

import com.spore.vxmoviesapp.data.offline.db.VxRoomDb
import com.spore.vxmoviesapp.data.offline.entity.MyList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VxLocalWatchListRepositoryImpl @Inject constructor(private val roomDb: VxRoomDb) : VxLocalWatchListRepository {
    override suspend fun addToWatchList(myList: MyList) {
        roomDb.myListDao.addToWatchList(myList)
    }

    override fun getFullWatchList(): Flow<List<MyList>> {
        return roomDb.myListDao.getWatchList()
    }

    override suspend fun getExistIdFromWatchList(mediaId: Long): Long {
        return  roomDb.myListDao.isExistsInTheWatchList(mediaId)
    }

    override suspend fun removeFromMyList(mediaId: Long) {
        roomDb.myListDao.removeFromWatchList(mediaId)
    }
}