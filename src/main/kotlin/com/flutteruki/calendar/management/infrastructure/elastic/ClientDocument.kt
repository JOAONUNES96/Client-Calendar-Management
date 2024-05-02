package com.flutteruki.calendar.management.infrastructure.elastic

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import org.springframework.data.elasticsearch.annotations.Setting

/**
 * ElasticSearch Document for a client.
 * Represents a client in the system, identified by a username.
 */
@Document(indexName = "clients")
@Setting(replicas = 1)
data class ClientDocument(
    @Id
    val id: String? = null,
    @Field(type = FieldType.Text)
    val username: String,
    @Field(type = FieldType.Nested)
    val tasks: List<TaskDocument> = listOf()
)
