package com.example.solutionx.ui

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.solutionx.BuildConfig
import com.example.solutionx.R
import com.example.solutionx.databinding.ActivityMainBinding
import com.example.solutionx.utils.CustomLogger
import com.example.solutionx.utils.LogLevel
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val writeExternalStorageLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Permission granted, proceed with other tasks
            // (You can call CustomLogger.log here)
            CustomLogger.log(LogLevel.DEBUG, "Write permission granted, logging message")
        } else {
            // Permission denied, handle gracefully (e.g., show a toast)
            CustomLogger.log(LogLevel.DEBUG, "Write permission denied")

            Toast.makeText(this, "Write permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
          when(BuildConfig.FLAVOR){
           "logWriter" ->  checkWriteExternalStoragePermission()
              "logCat" ->   CustomLogger.log(LogLevel.DEBUG, "logcat debug")
               else -> Unit
          }
        val deviceLanguage = Locale.getDefault().language
        val fontResourceId = if (deviceLanguage == "en") {
            R.font.galano_bold
        } else {
            R.font.tajawal_bold
        }
        binding.textView.typeface = resources.getFont(fontResourceId)



    }
    private fun checkWriteExternalStoragePermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            writeExternalStorageLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        } else {
            // Permission already granted, proceed with other tasks
            // (You can call CustomLogger.log here)
            CustomLogger.log(LogLevel.DEBUG, "Write permission already granted")

        }
    }
}