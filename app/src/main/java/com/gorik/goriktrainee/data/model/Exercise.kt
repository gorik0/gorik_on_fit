package com.gorik.goriktrainee.data.model

import androidx.compose.runtime.Stable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Entity
@Serializable
@Stable
data class Exercise(
    @PrimaryKey val name: String,
    val target: MuscleGroups,
    val reference: String? = null,
    val isIsometric: Boolean = false,
)


private fun MuscleGroups.exercise(block: MutableList<String>.() -> Unit): List<Exercise> {
    val li = mutableListOf<String>()

    li.apply(block)
    return li.map { Exercise(name = it, target = this) }
}

val MuscleGroups.sampleExercises
    get() = when(this){

        MuscleGroups.Biceps -> exercise { add("Curls"); add("Barbell Curls"); add("Preacher Curls"); add("B-t-B Curls") }
        MuscleGroups.Triceps -> exercise { add("Push-down"); add("Skull-Crushers"); add("Push-overs") }
        MuscleGroups.Shoulders -> exercise { add("Lateral Raises"); add("Shoulder Press"); add("Face Pulls") }
        MuscleGroups.Quads -> exercise { add("Squats"); add("Leg Press"); add("Hack Squats"); add("Leg Extensions") }
        MuscleGroups.Hamstrings -> exercise { add("SDL"); add("Lying Leg Curls") }
        MuscleGroups.Calves -> exercise { add("Calve Raises") }
        MuscleGroups.Glutes -> exercise { add("Hip Thrusts"); add("Lunges") }
        MuscleGroups.Core -> exercise { add("Sit-ups"); add("Leg Raises") }
        MuscleGroups.Chest -> exercise { add("Bench Press"); add("Incline Bench"); add("Pec Dec"); add("Chest Fly") }
        MuscleGroups.Traps -> exercise { add("Shrugs") }
        MuscleGroups.Lats -> exercise { add("Lat Pull-down"); add("Pull-ups"); add("Lat Prayers") }
        MuscleGroups.UpperBack -> exercise { add("Bent-over Rows"); add("Chest-Supported Rows"); add("Rows") }
    }
