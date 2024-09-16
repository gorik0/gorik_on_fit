package com.gorik.goriktrainee.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.gorik.goriktrainee.data.model.Exercise


@Dao
interface ExerciseDao {


    @Upsert
    suspend fun upsert(exercise: Exercise)

    @Query("DELETE from exercise where name= :name")
    fun delete(name: String)


    @Query("SELECT * from exercise")
    suspend fun stream(): kotlinx.coroutines.flow.Flow<List<Exercise>>

    @Query("SELECT * from exercise where name = :name")
    suspend fun get (name: String): Exercise?
}
