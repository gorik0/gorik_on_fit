package com.gorik.goriktrainee.di

import android.content.Context
import com.gorik.goriktrainee.data.local.GorikFitnessDatabase
import com.gorik.goriktrainee.data.local.dao.ExerciseDao
import com.gorik.goriktrainee.data.local.dao.PlanDao
import com.gorik.goriktrainee.data.local.dao.SessionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton




@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope



@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {



    @Provides
    @Singleton
    fun provideDatabase(context: Context):GorikFitnessDatabase = GorikFitnessDatabase.create(context)



    @Provides
    @Singleton
    fun provideExerciseDao(db: GorikFitnessDatabase):ExerciseDao = db.exerciseDao

    @Provides
    @Singleton
    fun provideSessionDao(db: GorikFitnessDatabase):SessionDao = db.sessionDao

    @Provides
    @Singleton
    fun providePlanDao(db: GorikFitnessDatabase):PlanDao = db.planDao



}
