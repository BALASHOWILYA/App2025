package com.example.myapplication.presentaition.services

import com.example.myapplication.R
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat


@Suppress("DEPRECATION")
class NotificationService : Service() {

    companion object {
        const val CHANNEL_ID = "ForegroundServiceChannel"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        //startForegroundNotification()
    }

    override fun onBind(intent: Intent): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("SERVICE", "service started ")

        sendCustomNotification("Регистрация", "Вы успешно зарегистрировались")
        return START_STICKY
    }


    @SuppressLint("ForegroundServiceType")
    private fun startForegroundNotification(){


        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Добро пожаловать ")
            .setContentText("приложение для всех")
            .setSmallIcon(com.example.myapplication.R.drawable.course)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build()
        startForeground(1, notification)
    }

    private fun sendCustomNotification(title: String, message: String){

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(com.example.myapplication.R.drawable.course)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(2, notification)
    }

    private fun createNotificationChannel(){
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ){
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Forground Service Channel",
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(serviceChannel)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopForeground(true)
    }
}