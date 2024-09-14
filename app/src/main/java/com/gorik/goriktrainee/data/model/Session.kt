package com.gorik.goriktrainee.data.model

import androidx.compose.runtime.Stable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDate


@Entity
@Stable
data class Session(
    val sets: List<Set>,
    @PrimaryKey val day: kotlinx.datetime.LocalDate
) {

    companion object {
        fun create(sets: List<Set>): Session {
            return Session(sets = sets, day = localDate)
        }


        val SAMPLE = Session(emptyList(), LocalDate(2024, 10, 6))
    }
}



val Session.sumRating:Double
    get() = sets.sumOf { it.rating }
