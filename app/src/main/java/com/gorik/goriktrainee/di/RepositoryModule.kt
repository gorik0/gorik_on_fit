package com.gorik.goriktrainee.di

import com.gorik.goriktrainee.data.local.datastore.DataStoreSettingsRepo
import com.gorik.goriktrainee.data.repository.ExercisesRepo
import com.gorik.goriktrainee.data.repository.PlanRepo
import com.gorik.goriktrainee.data.repository.SessionRepo
import com.gorik.goriktrainee.data.repository.SettingsRepo
import com.gorik.goriktrainee.data.repository.offline.OffExerciseRepo
import com.gorik.goriktrainee.data.repository.offline.OffPlanRepo
import com.gorik.goriktrainee.data.repository.offline.OffSessionRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {



    @Binds
abstract  fun bindEserciseRepo(exerciseRepo: OffExerciseRepo):ExercisesRepo

    @Binds
    abstract  fun bindSessionRepo(session: OffSessionRepo):SessionRepo

    @Binds
    abstract  fun bindPlanRepo(planeRepo: OffPlanRepo): PlanRepo

    @Binds
    abstract  fun bindSettingRepos(setingRepo: DataStoreSettingsRepo):SettingsRepo


}
