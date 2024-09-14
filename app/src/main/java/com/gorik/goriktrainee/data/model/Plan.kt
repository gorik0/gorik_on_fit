package com.gorik.goriktrainee.data.model

import androidx.compose.runtime.Stable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import java.time.Clock
import java.time.DayOfWeek

@Stable
@Entity(tableName = "plan_table")
data class Plan(
    val name :String,
    val isActive:Boolean,
    val excercisesPerDay: Map<DayOfWeek,List<Exercise>>,
    @PrimaryKey (autoGenerate = true) val id:Long? = null,
) {
}


val localDate = kotlinx.datetime.Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
data class PlanStat(
    val exercises: Int,
    val restDaysCount: Int,
    val workoutDaysCount: Int = 7-restDaysCount,

)

