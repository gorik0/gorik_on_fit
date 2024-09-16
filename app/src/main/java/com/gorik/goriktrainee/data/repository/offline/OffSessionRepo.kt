package com.gorik.goriktrainee.data.repository.offline

import com.gorik.goriktrainee.data.local.dao.SessionDao
import com.gorik.goriktrainee.data.model.Session
import com.gorik.goriktrainee.data.model.Set
import com.gorik.goriktrainee.data.model.localDate
import com.gorik.goriktrainee.data.repository.SessionRepo
import com.gorik.goriktrainee.utils.isToday
import com.gorik.goriktrainee.utils.updateAsMutable
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDate
import javax.inject.Inject

class OffSessionRepo @Inject constructor(
    val dao: SessionDao
) : SessionRepo {
    override val stream: Flow<List<Session>>
        get() = dao.stream()

    override suspend fun updateSet(sets: List<Set>) {
        dao.updateSets(date = localDate, sets = sets)
    }

    override suspend fun addSet(date: LocalDate, set: Set) {
        if (!date.isToday) error("Editing on old dates is not supported!")
        val currentSession: Session = get(date) ?: error("FOR local date shoudl be null")
        val updatedSets = currentSession.sets.updateAsMutable { add(set) }
        dao.upsert(currentSession.copy(sets = updatedSets))
    }

    override suspend fun removeSet(date: LocalDate, set: Set) {
        if (!date.isToday) error("Editing on old dates is not supported!")
        val currentSession: Session = get(date) ?: error("FOR local date shoudl be null")
        val updatedSets = currentSession.sets.updateAsMutable { remove(set) }
        dao.upsert(currentSession.copy(sets = updatedSets))
    }

    override suspend fun createEmpty() {
        return dao.upsert(Session.create(emptyList()))
    }

    override suspend fun get(date: LocalDate): Session? {
        val todaySession = dao.getSession(date)
        if (todaySession != null || !date.isToday) {
            return todaySession
        }
        if (!date.isToday) {
            return dao.getSession(date)
        }
        createEmpty()
        return dao.getSession(date)
    }

    override fun getStream(date: LocalDate): Flow<Session?> {
        return dao.session(date)
    }
}
