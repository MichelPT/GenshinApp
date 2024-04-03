package com.example.core.utils

import org.jetbrains.annotations.VisibleForTesting
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors @VisibleForTesting constructor(
    private val diskIO: Executor
) {
    @VisibleForTesting constructor():this(
        Executors.newSingleThreadExecutor()
    )

    fun diskIO(): Executor = diskIO

    companion object
}