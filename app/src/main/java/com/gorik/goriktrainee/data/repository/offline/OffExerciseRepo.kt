package com.gorik.goriktrainee.data.repository.offline

import com.gorik.goriktrainee.data.local.dao.ExerciseDao
import com.gorik.goriktrainee.data.model.Exercise
import com.gorik.goriktrainee.data.repository.ExercisesRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OffExerciseRepo @Inject constructor(val dao: ExerciseDao) : ExercisesRepo {

    override val stream: Flow<List<Exercise>>
        get() = dao.stream()

    override suspend fun getByName(name: String): Exercise? {
        return dao.get(name)
    }

    override suspend fun upsert(name: Exercise) {
        return dao.upsert(name)
    }

    override fun remove(name: String) {
        dao.delete(name)
    }

    override suspend  fun isExerciseAvailable(name: String): Boolean {
        return getByName(name) != null
    }
}
