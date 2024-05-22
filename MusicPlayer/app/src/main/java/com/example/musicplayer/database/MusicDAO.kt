package com.example.musicplayer.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.musicplayer.datas.Music

@Dao
interface MusicDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMusic(user: Music)

    @Query("SELECT * FROM musics")
    suspend fun getAllMusic(): List<Music>
}