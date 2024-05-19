package com.example.musicplayer.database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "musics")
data class Music(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val author: String
)
