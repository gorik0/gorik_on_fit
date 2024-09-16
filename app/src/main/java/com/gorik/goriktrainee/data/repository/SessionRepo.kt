package com.gorik.goriktrainee.data.repository

import com.gorik.goriktrainee.data.model.Session
import kotlinx.datetime.LocalDate
import java.util.concurrent.Flow
import com.gorik.goriktrainee.data.model.Set as Set

interface SessionRepo {


    val stream:kotlinx.coroutines.flow.Flow<List<Session>>

    suspend fun updateSet(sets: List<Set>)

    suspend fun addSet(date: LocalDate, set: Set)

    suspend fun removeSet(date: LocalDate, set: Set)

    suspend fun createEmpty()

    suspend fun get(date: LocalDate): Session?

    fun getStream(date: LocalDate): kotlinx.coroutines.flow.Flow<Session?>
}
