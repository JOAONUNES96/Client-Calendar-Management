package com.flutteruki.calendar.management.domain.model


/**
 * Represents a client in the system, identified by a username.
 */
data class Client(
    val id: String? = null,
    val username: String,
    val tasks: List<Task> = listOf()
)