package com.example.musicplayer.datas
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "musics")
data class Music(
    @PrimaryKey() val path: String,
    val title: String,
    val album: String?,
    val author: String?,
)
