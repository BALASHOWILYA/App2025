package com.example.myapplication.presentaition.application

import android.app.Application
import com.example.myapplication.presentaition.di.appdi.appModule
import com.example.myapplication.presentaition.di.datadi.dataModule
import com.example.myapplication.presentaition.di.domaindi.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {


   override fun onCreate() {
      super.onCreate()
      startKoin{
         androidLogger(Level.DEBUG)
         androidContext(this@MyApplication)
         modules(listOf(appModule, dataModule, domainModule))
      }
   }
}