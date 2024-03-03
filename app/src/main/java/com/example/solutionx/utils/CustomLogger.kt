package com.example.solutionx.utils

import android.util.Log
import com.example.solutionx.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileWriter
import java.io.IOException

object CustomLogger {
    fun log(logLevel: LogLevel, message: String) {
        when (BuildConfig.FLAVOR) {
            "logCat" -> logToLogcat(logLevel, message)
            "logWriter" -> writeToFile(message)
            // "production" flavor does nothing
            else -> Unit
        }
    }

    private fun logToLogcat(logLevel: LogLevel, message: String) {
        Log.println(logLevel.level, "CustomLogger", message)
    }


    private fun writeToFile(message: String) {
        CoroutineScope(Dispatchers.IO).launch {

                val directory = File("/storage/emulated/0/Download/SolutionX")
                if (!directory.exists()) {
                    directory.mkdirs()
                }

                val file = File(directory, "log.txt")
                try {
                    FileWriter(file, true).use { writer ->
                        writer.append(message).append("\n")
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }

        }
    }
}