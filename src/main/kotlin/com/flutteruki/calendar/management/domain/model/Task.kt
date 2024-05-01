package com.flutteruki.calendar.management.domain.model

import java.time.LocalDateTime

/**
 * Represents a task, which is a calendar item.
 */
data class Task(
    override val id: String? = null,
    override val name: String,
    override val dateTime: LocalDateTime,
    override val description: String,
    override val location: String
) : CalendarItem