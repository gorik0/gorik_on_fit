package com.gorik.goriktrainee.data.repository

import android.provider.Settings
import com.gorik.goriktrainee.data.model.settings.ColorPallete
import com.gorik.goriktrainee.data.model.settings.Theme
import kotlinx.coroutines.flow.Flow

interface SettingsRepo {

    val stream: Flow<Settings>



    suspend fun setOnBoardingDone()
    suspend fun setTheme(theme:Theme)
    suspend fun setColorPalette(palette:ColorPallete)

}
