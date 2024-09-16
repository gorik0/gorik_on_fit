package com.gorik.goriktrainee.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gorik.goriktrainee.data.local.dao.ExerciseDao
import com.gorik.goriktrainee.data.local.dao.PlanDao
import com.gorik.goriktrainee.data.local.dao.SessionDao
import com.gorik.goriktrainee.data.model.Exercise
import com.gorik.goriktrainee.data.model.Plan
import com.gorik.goriktrainee.data.model.Session


@Database(
    version = 1,
    entities = [
        Plan::class,
        Session::class,
        Exercise::class,
    ]
)
@androidx.room.TypeConverters(TypeConverters::class)
abstract class GorikFitnessDatabase : RoomDatabase() {

    abstract val planDao: PlanDao
    abstract val exerciseDao: ExerciseDao

    abstract val sessionDao: SessionDao


    companion object {

        fun create(context: Context): GorikFitnessDatabase {

            return Room.databaseBuilder(
                context = context,
                klass = GorikFitnessDatabase::class.java,
                name = "fitness_db",
            ).createFromAsset("gorik.db")
                .build()

        }
    }
}
