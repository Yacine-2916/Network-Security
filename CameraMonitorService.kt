package com.yacine.security

import android.app.Service
import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraManager
import android.os.IBinder
import android.util.Log

class CameraMonitorService : Service() {

    private lateinit var cameraManager: CameraManager

    override fun onCreate() {
        super.onCreate()
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager

        cameraManager.registerAvailabilityCallback(object : CameraManager.AvailabilityCallback() {
            override fun onCameraAvailable(cameraId: String) {
                Log.d("CameraMonitor", "Caméra $cameraId libre")
            }

            override fun onCameraUnavailable(cameraId: String) {
                Log.d("CameraMonitor", "Caméra $cameraId utilisée !")
            }
        }, null)
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
