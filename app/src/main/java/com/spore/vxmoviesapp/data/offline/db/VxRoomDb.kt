package com.spore.vxmoviesapp.data.offline.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.spore.vxmoviesapp.data.offline.dao.MyListDao
import com.spore.vxmoviesapp.data.offline.entity.MyList

@Database(
    version = 1,
    entities = [MyList::class],
    exportSchema = false
)
abstract class VxRoomDb : RoomDatabase() {
    abstract val myListDao: MyListDao
}