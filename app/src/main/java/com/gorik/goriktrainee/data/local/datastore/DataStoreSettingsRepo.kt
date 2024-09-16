package com.gorik.goriktrainee.data.local.datastore

import android.provider.Settings
import com.gorik.goriktrainee.data.model.settings.ColorPallete
import com.gorik.goriktrainee.data.model.settings.Theme
import com.gorik.goriktrainee.data.repository.SettingsRepo
import kotlinx.coroutines.flow.Flow

class DataStoreSettingsRepo: SettingsRepo {
    override val stream: Flow<Settings>
        get() = TODO("Not yet implemented")

    override suspend fun setOnBoardingDone() {
        TODO("Not yet implemented")
    }

    override suspend fun setTheme(theme: Theme) {
        TODO("Not yet implemented")
    }

    override suspend fun setColorPalette(palette: ColorPallete) {
        TODO("Not yet implemented")
    }
}
