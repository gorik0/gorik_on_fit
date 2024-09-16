package com.gorik.goriktrainee.data.repository

import com.gorik.goriktrainee.data.model.Exercise
import com.gorik.goriktrainee.data.model.Plan
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface PlanRepo {


    val stream: Flow<List<Plan>>
    val current: Flow<Plan?>

    fun getById(id: Long?): Flow<Plan?>
    fun upsert(plan: Plan)
    fun remove(id: Long)
    fun switchPlan(plan: Plan)
    fun exercises(date: LocalDate): Flow<List<Exercise>?>

    fun currentPlan(): Plan?
}
