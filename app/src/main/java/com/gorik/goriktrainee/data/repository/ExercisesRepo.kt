package com.gorik.goriktrainee.data.repository

import com.gorik.goriktrainee.data.model.Exercise
import kotlinx.coroutines.flow.Flow

interface ExercisesRepo {


    val stream: Flow<List<Exercise>>

    suspend fun getByName(name: String): Exercise?
    fun remove(name: String)
    suspend fun upsert(name: Exercise)
    suspend fun isExerciseAvailable(name: String): Boolean
}
