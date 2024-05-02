package com.flutteruki.calendar.management.infrastructure.adapters

import com.flutteruki.calendar.management.domain.model.Event
import com.flutteruki.calendar.management.domain.ports.EventRepositoryPort
import com.flutteruki.calendar.management.infrastructure.elastic.EventRepository
import com.flutteruki.calendar.management.infrastructure.mappers.EventMapper
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EventRepositoryAdapter(
    @Autowired private val springDataEventRepository: EventRepository
) : EventRepositoryPort {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    override suspend fun save(event: Event): Boolean {
        val elasticSuccess = try {
            logger.debug("operation=save, message='saving Event {}'", event)
            springDataEventRepository.save(EventMapper.toEventDocument(event)).awaitFirstOrNull()
            true
        } catch (e: Exception) {
            logger.error(
                "operation=insertOrUpdate, message=Failed to insert or update " +
                        "in Elastic repository, record=$event", e
            )
            false
        }
        if (!elasticSuccess) {
            logger.error(
                "operation=insertOrUpdate, message='Failed to insert in ELASTIC"
            )
        }
        return elasticSuccess
    }
}

/*
curl -X POST -H "Content-Type: application/json" -d '{
"id": "1",
"name": "Evento de teste",
"dateTime": "2024-05-02T13:56:11",
"description": "Este é um evento de teste",
"location": "Localização de teste",
"participants": []
}' http://localhost:8080/api/events*/
