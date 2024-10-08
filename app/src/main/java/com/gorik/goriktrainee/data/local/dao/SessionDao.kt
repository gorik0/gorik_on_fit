package com.gorik.goriktrainee.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.gorik.goriktrainee.data.model.Session
import com.gorik.goriktrainee.data.model.Set
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate


@Dao
interface SessionDao {



    @Upsert
    suspend fun upsert(session: Session)


    @Query("UPDATE session SET sets = :sets WHERE day = :date")
    suspend fun updateSets(date: LocalDate, sets: List<Set>)

    @Query("SELECT * FROM session")
    fun stream(): Flow<List<Session>>

    @Query("SELECT * FROM session WHERE day = :date")
    fun session(date: LocalDate): Flow<Session>

    @Query("SELECT * FROM session WHERE day = :date")
    suspend fun getSession(date: LocalDate): Session?



}
