package com.flutteruki.calendar.management.domain.model

/**
 * Represents an event, which is a calendar item that can have multiple participants.
 */
data class Event(
    override val id: String? = null,
    override val name: String,
    override val dateTime: String,
    override val description: String,
    override val location: String,
    val participants: List<Client>
) : CalendarItem
