package com.example.musicplayer

import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        private var instance: MyApplication? = null

        fun applicationContext(): MyApplication {
            return instance as MyApplication
        }
    }

    init {
        instance = this
    }
}