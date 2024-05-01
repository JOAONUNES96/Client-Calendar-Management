package com.flutteruki.calendar.management.infra.mappers

import com.flutteruki.calendar.management.domain.model.Client
import com.flutteruki.calendar.management.infra.elastic.ClientDocument

object ClientMapper {
    fun toClientDocument(client: Client): ClientDocument {
        return ClientDocument(
            id = client.id,
            username = client.username,
            tasks = client.tasks.map { TaskMapper.toTaskDocument(it) }
        )
    }

    fun toClient(clientEntity: ClientDocument): Client {
        return Client(
            id = clientEntity.id,
            username = clientEntity.username,
            tasks = clientEntity.tasks.map { TaskMapper.toTask(it) }
        )
    }
}