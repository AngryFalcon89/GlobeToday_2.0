package com.example.newsapp.domain.manager

import kotlinx.coroutines.flow.Flow
/**
 * Step 1: Define the LocalUserManager interface for managing user-related preferences using DataStore.
 *
 * This interface declares methods to save and read the "App Entry" preference asynchronously.
 * The "App Entry" preference represents whether the user has entered the app before.
 */
interface LocalUserManager {

    /**
     * Saves the "App Entry" preference asynchronously.
     * This method is used to update the user's entry status when needed.
     */
    suspend fun saveAppEntry()

    /**
     * Reads the "App Entry" preference as a Flow<Boolean>.
     * This Flow emits the current status of the user's entry into the app.
     */
    fun readAppEntry(): Flow<Boolean>

}
