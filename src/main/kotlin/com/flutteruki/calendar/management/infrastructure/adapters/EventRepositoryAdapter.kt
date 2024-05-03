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

    override suspend fun findById(id: String): Event? {
        TODO("Not yet implemented")
    }

    override suspend fun findAll(): List<Event> {
        logger.debug("operation=findAll, message='Finding all events with pagination and sorting'")
        TODO("Not yet implemented")

    }


    override suspend fun deleteById(id: String): Boolean {
        return try {
            logger.debug("operation=deleteById, message='deleting Event with id {}'", id)
            springDataEventRepository.deleteById(id).awaitFirstOrNull()
            true
        } catch (e: Exception) {
            logger.error(
                "operation=deleteById, message=Failed to delete " +
                        "in Elastic repository, record=$id", e
            )
            false
        }
    }
}