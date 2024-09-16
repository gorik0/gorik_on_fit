package com.gorik.goriktrainee.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.todayIn
import java.time.LocalDate


val kotlinx.datetime.LocalDate.isToday:Boolean
    get()=daysUntil(Clock.System.todayIn(TimeZone.currentSystemDefault()))==0
