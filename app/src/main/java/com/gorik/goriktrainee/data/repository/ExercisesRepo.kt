package com.gorik.goriktrainee.data.repository

import com.gorik.goriktrainee.data.model.Exercise
import kotlinx.coroutines.flow.Flow

interface ExercisesRepo {


    val stream: Flow<List<Exercise>>

    fun getByName(name: String): Exercise?
    fun remove(name: String)
    fun upsert(name: String)
    fun isExerciseAvailable(name: String): Boolean
}
