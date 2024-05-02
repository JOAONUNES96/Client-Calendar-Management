package com.flutteruki.calendar.management.domain.ports

import com.flutteruki.calendar.management.domain.model.Event

interface EventRepositoryPort {
    suspend fun save(event: Event): Boolean
}