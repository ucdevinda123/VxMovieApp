package com.spore.vxmoviesapp.di

import android.app.Application
import androidx.room.Room
import com.spore.vxmoviesapp.data.offline.db.VxRoomDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object VxLocalCacheDepModule {

    @Provides
    fun provideRoomDb(application: Application): VxRoomDb {
        return Room.databaseBuilder(
            application.applicationContext,
            VxRoomDb::class.java,
            "vx_room_db",
        ).fallbackToDestructiveMigration().build()
    }
}
