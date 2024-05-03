package com.flutteruki.calendar.management.domain.ports

import com.flutteruki.calendar.management.domain.model.Event
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import reactor.core.publisher.Mono

interface EventRepositoryPort {
    suspend fun save(event: Event): Boolean

    suspend fun findById(id: String): Event?

    suspend fun findAll(pageable: Pageable): Page<Event>

    suspend fun deleteById(id: String): Boolean
}