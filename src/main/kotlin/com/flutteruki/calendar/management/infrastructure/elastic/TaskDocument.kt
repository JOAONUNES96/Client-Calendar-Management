package com.flutteruki.calendar.management.infrastructure.elastic

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import org.springframework.data.elasticsearch.annotations.Setting
import java.time.LocalDateTime

/**
 * ElasticSearch Document for a task.
 * Represents a task, which is a calendar item.
 */
@Document(indexName = "tasks")
@Setting(replicas = 1)
data class TaskDocument(
    @Id
    val id: String? = null,
    @Field(type = FieldType.Text)
    val name: String,
    @Field(type = FieldType.Date)
    val dateTime: LocalDateTime,
    @Field(type = FieldType.Text)
    val description: String,
    @Field(type = FieldType.Text)
    val location: String
)
