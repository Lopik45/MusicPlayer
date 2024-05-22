package com.example.musicplayer

import android.content.Context
import android.content.pm.PackageManager
import android.provider.MediaStore
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.musicplayer.datas.Music


class FileManager {

    fun getMP3File(context: Context): List<Music> {
        val tempAudioList = mutableListOf<Music>()

        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_MEDIA_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            Log.e("FileManager", "Permission READ_MEDIA_AUDIO non accordée")
        }

        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.AudioColumns.DATA,
            MediaStore.Audio.AudioColumns.TITLE,
            MediaStore.Audio.AudioColumns.ALBUM,
            MediaStore.Audio.ArtistColumns.ARTIST
        )
        val selection = "${MediaStore.Audio.Media.DATA} like ?"
        val selectionArgs = arrayOf("%mp3%")

        context.contentResolver.query(uri, projection, null, null, null)?.use { cursor ->
            if (cursor.count <= 0) {
                Log.d("FileManager", "No audio files found")
            }
            while (cursor.moveToNext()) {
                if (cursor.getString(2) == constant.DOWNLOAD_FOLDER_NAME){

                }
                val audioModel: Music = Music(
                    cursor.getString(3),
                    cursor.getString(1),
                    if(cursor.getString(2) == constant.DOWNLOAD_FOLDER_NAME) cursor.getString(2) else null,
                    cursor.getString(0))
                Log.d("FileManager", "Name :${audioModel.title} Album :${audioModel.album}")
                Log.d("FileManager", "Path :${audioModel.path} Artist :${audioModel.author}")
                tempAudioList.add(audioModel)
            }
        }

        return tempAudioList
    }
}