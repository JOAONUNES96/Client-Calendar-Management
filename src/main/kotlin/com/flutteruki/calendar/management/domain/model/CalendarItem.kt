package com.flutteruki.calendar.management.domain.model

import java.time.LocalDateTime

/**
 * Interface for calendar items such as events and tasks.
 */
interface CalendarItem {
    val id: String?
    val name: String
    val dateTime: LocalDateTime
    val description: String
    val location: String
}