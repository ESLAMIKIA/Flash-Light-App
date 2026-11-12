
package com.example.flash_light

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var cameraManager: CameraManager
    private lateinit var cameraId: String

    private lateinit var flashImage: ImageView
    private lateinit var flashContainer: FrameLayout
    private lateinit var txtStatus: TextView
    private lateinit var txtInstruction: TextView

    private var isTorchOn = false

    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->

            if (granted) {
                turnOnFlash()
            } else {
                Toast.makeText(
                    this,
                    "Camera permission is required!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        flashImage = findViewById(R.id.flashImage)
        flashContainer = findViewById(R.id.flashContainer)
        txtStatus = findViewById(R.id.txtStatus)
        txtInstruction = findViewById(R.id.txtInstruction)

        cameraManager =
            getSystemService(Context.CAMERA_SERVICE) as CameraManager

        val availableCamera = cameraManager.cameraIdList.firstOrNull { id ->
            cameraManager.getCameraCharacteristics(id)
                .get(CameraCharacteristics.FLASH_INFO_AVAILABLE) == true
        }

        if (availableCamera == null) {
            Toast.makeText(
                this,
                "Flashlight is not available on this device",
                Toast.LENGTH_LONG
            ).show()

            flashContainer.isEnabled = false
            return
        }

        cameraId = availableCamera

        updateUI()

        flashContainer.setOnClickListener {
            if (isTorchOn) {
                turnOffFlash()
            } else {
                checkPermissionAndTurnOn()
            }
        }
    }

    private fun checkPermissionAndTurnOn() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            turnOnFlash()
        } else {
            permissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    private fun turnOnFlash() {
        try {
            cameraManager.setTorchMode(cameraId, true)
            isTorchOn = true
            updateUI()

        } catch (e: Exception) {
            Toast.makeText(
                this,
                "Could not turn on flashlight",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun turnOffFlash() {
        try {
            cameraManager.setTorchMode(cameraId, false)
            isTorchOn = false
            updateUI()

        } catch (e: Exception) {
            Toast.makeText(
                this,
                "Could not turn off flashlight",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun updateUI() {
        if (isTorchOn) {
            flashImage.setImageResource(R.drawable.flash_on)
            txtStatus.text = "LIGHT IS ON"
            txtStatus.setTextColor(
                android.graphics.Color.parseColor("#FFD54F")
            )
            txtInstruction.text = "Tap to turn off"
            flashContainer.alpha = 1f

        } else {
            flashImage.setImageResource(R.drawable.flashlight_off)
            txtStatus.text = "LIGHT IS OFF"
            txtStatus.setTextColor(
                android.graphics.Color.parseColor("#888888")
            )
            txtInstruction.text = "Tap the button to turn on"
            flashContainer.alpha = 0.65f
        }
    }

    override fun onDestroy() {
        if (isTorchOn) {
            try {
                cameraManager.setTorchMode(cameraId, false)
            } catch (_: Exception) {
            }
        }

        super.onDestroy()
    }
}
