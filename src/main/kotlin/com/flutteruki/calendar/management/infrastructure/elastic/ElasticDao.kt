package com.flutteruki.calendar.management.infrastructure.elastic

import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.core.query.Query
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@Repository
interface ClientRepository : ReactiveElasticsearchRepository<ClientDocument, String> {
    fun save(client: ClientDocument): ClientDocument
    override fun findById(id: String): Mono<ClientDocument>
    override fun findAll(): Flux<ClientDocument>
    override fun deleteById(id: String): Mono<Void>
}

@Repository
interface TaskRepository : ReactiveElasticsearchRepository<TaskDocument, String> {
    fun save(task: TaskDocument): TaskDocument
     override fun findById(id: String): Mono<TaskDocument>
    override fun findAll(): Flux<TaskDocument>
    override fun deleteById(id: String): Mono<Void>
}

@Repository
interface EventRepository : ReactiveElasticsearchRepository<EventDocument, String>{
    override fun findById(id: String):Mono<EventDocument>
    override fun findAll(): Flux<EventDocument>
    override fun deleteById(id: String): Mono<Void>
}