package com.gorik.goriktrainee.data.model.settings

import androidx.annotation.StringRes
import androidx.compose.material3.ColorScheme
import com.gorik.goriktrainee.R

enum class Theme (@StringRes val nameRes:Int) {

    System(R.string.system),
    Light(R.string.light),
    Dark(R.string.dark),
}


enum class ColorPallete(val scheme: ColorScheme){
//    Dynamic(null),
//    Default(defaultColorSchemes),
//    Zestful(zestfulColorSchemes),
//    Serene(sereneColorSchemes),
//    Twilight(twilightColorSchemes),
}
