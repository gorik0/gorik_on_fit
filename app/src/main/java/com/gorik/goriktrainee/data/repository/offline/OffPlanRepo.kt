package com.gorik.goriktrainee.data.repository.offline

import com.gorik.goriktrainee.data.local.dao.PlanDao
import com.gorik.goriktrainee.data.model.Exercise
import com.gorik.goriktrainee.data.model.Plan
import com.gorik.goriktrainee.data.repository.PlanRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class OffPlanRepo(val dao: PlanDao) : PlanRepo {
    override val stream: Flow<List<Plan>>
        get() = dao.stream()
    override val current: Flow<Plan?>
        get() = dao.currentActiveStream()

    override fun getById(id: Long?): Flow<Plan?> {
        return id?.let { dao.get(it) } ?: flowOf(null)
    }

    override fun upsert(plan: Plan) {
        val isActivable = plan.isActive && plan.id != null
        if (isActivable) {
            dao.upsert(plan)
            dao.setActive(plan.id!!)
        } else {

            dao.upsert(plan.copy(isActive = false))

        }
    }

    override fun remove(id: Long) {
        dao.remove(id)
    }


    override fun switchPlan(plan: Plan) {
        dao.setActive(id = plan.id!!)
    }

    override fun exercises(date: LocalDate): Flow<List<Exercise>?> {
        return current.map { plan -> plan?.excercisesPerDay?.get(date.dayOfWeek) }
    }

    override fun currentPlan(): Plan? {
        return dao.currentPlan()
    }
}
