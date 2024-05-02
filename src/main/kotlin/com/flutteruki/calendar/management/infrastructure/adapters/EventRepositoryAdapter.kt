package com.flutteruki.calendar.management.infrastructure.adapters

import com.flutteruki.calendar.management.domain.model.Event
import com.flutteruki.calendar.management.domain.ports.EventRepositoryPort
import com.flutteruki.calendar.management.infrastructure.elastic.EventRepository
import com.flutteruki.calendar.management.infrastructure.mappers.EventMapper
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
            springDataEventRepository.save(EventMapper.toEventDocument(event))
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

