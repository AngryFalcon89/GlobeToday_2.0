package com.example.newsapp.domain.useCases.appEntry

import com.example.newsapp.domain.manager.LocalUserManager

/**
 * Step 4: Use case class responsible for invoking the saveAppEntry method in LocalUserManager.
 *
 * @param localUserManager The LocalUserManager implementation used for managing user-related preferences.
 */
class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    /**
     * Invokes the saveAppEntry method asynchronously.
     * This method is part of a use case and should be called to update the user's entry status.
     */
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}
