package com.spore.vxmoviesapp.data.offline.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_watch_list")
data class MyList(
    @PrimaryKey val mediaId: Long,
    val imagePath: String?,
    val title: String,
)