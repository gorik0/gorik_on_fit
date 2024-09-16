package com.gorik.goriktrainee.data.local

import androidx.room.TypeConverter
import com.gorik.goriktrainee.data.model.Exercise
import com.gorik.goriktrainee.data.model.Set
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDate
import kotlinx.datetime.serializers.DayOfWeekSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.json.Json


private val json = Json
private val setListSerializer = ListSerializer(Set.serializer())
private val exerciseListSerializer = ListSerializer(Exercise.serializer())

private val exerciseMapSerializer =
    MapSerializer(DayOfWeekSerializer, ListSerializer(Exercise.serializer()))

class TypeConverters {


    @TypeConverter
    fun fromLocalDate(value: kotlinx.datetime.LocalDate): Int {
        return value.toEpochDays()
    }


    @TypeConverter
    fun toLocalDate(value: Int): LocalDate {
        return LocalDate.fromEpochDays(value)
    }

    @TypeConverter
    fun fromSetList(value: List<Set>): String {
        return json.encodeToString(setListSerializer, value)
    }
    @TypeConverter
    fun toExerciseMap(value: String): Map<DayOfWeek, List<Exercise>> {
        return json.decodeFromString(exerciseMapSerializer, value)
    }
    @TypeConverter
    fun toSetList(value: String): List<Set> {
        return json.decodeFromString(setListSerializer, value)
    }
    @TypeConverter
    fun fromExerciseList(value: List<Exercise>): String {
        return json.encodeToString(exerciseListSerializer, value)
    }

    @TypeConverter
    fun toExerciseList(value: String): List<Exercise> {
        return json.decodeFromString(exerciseListSerializer, value)
    }
    @TypeConverter
    fun fromExerciseMap(value: Map<DayOfWeek, List<Exercise>>): String {
        return json.encodeToString(exerciseMapSerializer, value)
    }

    @TypeConverter
    fun fromSet(value: Set): String {
        return json.encodeToString(Set.serializer(), value)
    }

    @TypeConverter
    fun toSet(value: String): Set {
        return json.decodeFromString(Set.serializer(), value)
    }

    @TypeConverter
    fun fromExercise(value: Exercise): String {
        return json.encodeToString(Exercise.serializer(), value)
    }

    @TypeConverter
    fun toExercise(value: String): Exercise {
        return json.decodeFromString(Exercise.serializer(), value)
    }

    @TypeConverter
    fun fromDayOfWeek(value: DayOfWeek): String {
        return json.encodeToString(DayOfWeekSerializer, value)
    }

    @TypeConverter
    fun toDayOfWeek(value: String): DayOfWeek {
        return json.decodeFromString(DayOfWeekSerializer, value)
    }
}
