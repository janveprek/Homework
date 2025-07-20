package com.veprek.honza.homework.design.presentation.mapper

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.format
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char

fun LocalDateTime.toFormattedUiDate(): String {
    val dateFormat = LocalDate.Format {
        day(padding = Padding.NONE)
        char('.')
        monthNumber(padding = Padding.NONE)
        char('.')
        char(' ')
        year()
    }
    val timeFormat = LocalTime.Format {
        hour(padding = Padding.NONE)
        char(':')
        minute()
    }

    return buildString {
        append(date.format(dateFormat))
        append(' ')
        append(time.format(timeFormat))
    }
}