package com.flutteruki.calendar.management.infrastructure.elastic

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import org.springframework.data.elasticsearch.annotations.Setting
import java.time.LocalDateTime

/**
 * ElasticSearch Document for an event.
 * Represents an event, which is a calendar item that can have multiple participants.
 */
@Document(indexName = "events")
@Setting(replicas = 1)
data class EventDocument(
    @Id
    val id: String? = null,
    @Field(type = FieldType.Text)
    val name: String,
    @Field(type = FieldType.Date)
    val dateTime: LocalDateTime,
    @Field(type = FieldType.Text)
    val description: String,
    @Field(type = FieldType.Text)
    val location: String,
    @Field(type = FieldType.Nested)
    val participants: List<ClientDocument>
)
