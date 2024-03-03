package com.example.solutionx.utils

import android.util.Log

enum class LogLevel(val level: Int) {
    VERBOSE(Log.VERBOSE),
    DEBUG(Log.DEBUG),
    INFO(Log.INFO),
    WARNING(Log.WARN),
    ERROR(Log.ERROR),
    ASSERT(Log.ASSERT)
}