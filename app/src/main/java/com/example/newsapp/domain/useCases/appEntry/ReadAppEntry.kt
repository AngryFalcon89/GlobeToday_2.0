package com.example.newsapp.domain.useCases.appEntry

import com.example.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

/**
 * Step 4: Use case class responsible for invoking the readAppEntry method in LocalUserManager.
 *
 * @param localUserManager The LocalUserManager implementation used for managing user-related preferences.
 */
class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    /**
     * Invokes the readAppEntry method, returning a Flow<Boolean>.
     * This method is part of a use case and should be called to observe the user's entry status.
     *
     * @return A Flow<Boolean> representing the "App Entry" preference.
     */
    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}
