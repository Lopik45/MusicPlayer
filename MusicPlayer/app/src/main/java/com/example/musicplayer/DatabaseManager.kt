package com.example.musicplayer

import android.app.Application
import com.example.musicplayer.database.AppDatabase

import com.example.musicplayer.datas.Music

import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DatabaseManager(application: Application) : AndroidViewModel(application){
    private var database : AppDatabase = AppDatabase.getDatabase(application.applicationContext)

    val allMusics: LiveData<List<Music>> = liveData {
        val musics = database.musicDao().getAllMusic()
        emit(musics)
    }

    fun write(music: Music) {
        //TODO: do conversion between MusicInfo(complex attribute) and Music(Primitive attribute)

        viewModelScope.launch {
            Log.d("DatabaseManager", "Write Music in database")
            database.musicDao().insertMusic(music)
            Log.d("DatabaseManager", "Finish writing Music in database")
        }
    }
}
