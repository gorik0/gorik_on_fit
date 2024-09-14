package com.gorik.goriktrainee.data.model

import androidx.compose.runtime.Stable
import kotlinx.serialization.Serializable


@Stable
@Serializable
data class Set(
    val repsORduration:Int,
    val weight: Double,
    val setTypes: SetType,
    val excercise: Exercise,

    )



val Set.rating
    get() = weight*repsORduration*setTypes.ratingModifier

enum class SetType(val ratingModifier:Double){
    Standard(STANDARD_SET_RATING_MODIFIER),
    Drop(DROP_SET_RATING_MODIFIER),
    RestPause(REST_PAUSE_SET_RATING_MODIFIER),
}


private const val STANDARD_SET_RATING_MODIFIER = 1.0
private const val DROP_SET_RATING_MODIFIER = 1.5
private const val REST_PAUSE_SET_RATING_MODIFIER = 1.7


val Set.Companion.samples
    get() = listOf(


        Set(12, 55.0, SetType.Standard, Exercise("Bench", MuscleGroups.Chest, ".reference")),
        Set(12, 55.0, SetType.Standard, Exercise("Bench", MuscleGroups.Chest, ".reference")),
        Set(12, 55.0, SetType.Standard, Exercise("Bench", MuscleGroups.Chest, ".reference")),
        Set(12, 55.0, SetType.Standard, Exercise("Incline Bench", MuscleGroups.Chest, ".reference")),
        Set(12, 55.0, SetType.Standard, Exercise("Incline Bench", MuscleGroups.Chest, ".reference")),
        Set(12, 55.0, SetType.Standard, Exercise("Incline Bench", MuscleGroups.Chest, ".reference")),
        Set(12, 55.0, SetType.Standard, Exercise("Pec-Dec", MuscleGroups.Chest, ".reference")),
        Set(12, 55.0, SetType.Standard, Exercise("Pec-Dec", MuscleGroups.Chest, ".reference")),
        Set(12, 55.0, SetType.Standard, Exercise("Pec-Dec", MuscleGroups.Chest, ".reference")),

        )
