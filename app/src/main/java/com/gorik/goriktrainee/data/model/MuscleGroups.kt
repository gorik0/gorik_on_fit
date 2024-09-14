package com.gorik.goriktrainee.data.model

import androidx.annotation.StringRes
import com.gorik.goriktrainee.R

enum class MuscleGroups(@StringRes val stringRes: Int) {


    // Arms
    Biceps(R.string.biceps_label),
    Triceps(R.string.triceps_label),
    Shoulders(R.string.shoulders_label),

    // Legs
    Quads(R.string.quads_label),
    Hamstrings(R.string.hamstrings_label),
    Calves(R.string.calves_label),
    Glutes(R.string.glutes_label),

    // Front
    Core(R.string.core_label),
    Chest(R.string.chest_label),

    // Back
    Traps(R.string.traps_label),
    Lats(R.string.lats_label),
    UpperBack(R.string.upperBack_label),
}
