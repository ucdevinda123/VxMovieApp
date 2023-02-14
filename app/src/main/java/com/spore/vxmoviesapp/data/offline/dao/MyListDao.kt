package com.spore.vxmoviesapp.data.offline.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.spore.vxmoviesapp.data.offline.entity.MyList
import kotlinx.coroutines.flow.Flow

@Dao
interface MyListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToWatchList(myList: MyList)

    @Query("SELECT * FROM my_watch_list")
    fun getWatchList(): Flow<List<MyList>>

    @Query("SELECT EXISTS (SELECT 1 FROM my_watch_list WHERE mediaId= :mediaId)")
    suspend fun isExistsInTheWatchList(mediaId: Long): Long

    @Query("DELETE FROM my_watch_list WHERE mediaId= :mediaId")
    suspend fun removeFromWatchList(mediaId:Long)
}