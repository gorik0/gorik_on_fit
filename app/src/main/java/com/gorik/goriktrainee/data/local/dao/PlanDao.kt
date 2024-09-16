package com.gorik.goriktrainee.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.gorik.goriktrainee.data.model.Plan
import kotlinx.coroutines.flow.Flow


@Dao
interface PlanDao {


    @Query("SELECT * from plan_table")
    fun stream(): Flow<List<Plan>>


    @Query("UPDATE plan_table set isActive = 1 where id = :id")
    fun setActive(id: Long)

    @Query("UPDATE plan_table set isActive = 0 where isActive =1")
    fun deactivate()


    @Query("SELECT * from plan_table where isActive  =1")
    fun currentActiveStream(): Flow<Plan>


    @Transaction
    fun changeActivePlan(id: Long) {
        deactivate()
        setActive(id)
    }

    @Query("SELECT * from plan_table where id = :id")
    fun get(id: Long): Flow<Plan?>

    @Query("DELETE  from plan_table where id = :id")
    fun remove(id: Long)

    @Query("SELECT * FROM plan_table where isActive = 1")
    fun currentPlan(): Plan?

    @Upsert
    fun upsert(plan: Plan)


}
