package com.flutteruki.calendar.management.infra.mappers

import com.flutteruki.calendar.management.domain.model.Event
import com.flutteruki.calendar.management.infra.elastic.EventDocument

object EventMapper {
    fun toEventDocument(event: Event): EventDocument {
        return EventDocument(
            id = event.id,
            name = event.name,
            dateTime = event.dateTime,
            description = event.description,
            location = event.location,
            participants = event.participants.map { ClientMapper.toClientDocument(it) }
        )
    }

    fun toEvent(eventEntity: EventDocument): Event {
        return Event(
            id = eventEntity.id,
            name = eventEntity.name,
            dateTime = eventEntity.dateTime,
            description = eventEntity.description,
            location = eventEntity.location,
            participants = eventEntity.participants.map { ClientMapper.toClient(it) }
        )
    }
}