package com.flutteruki.calendar.management.infra.mappers

import com.flutteruki.calendar.management.domain.model.Task
import com.flutteruki.calendar.management.infra.elastic.TaskDocument

object TaskMapper {
    fun toTaskDocument(task: Task): TaskDocument {
        return TaskDocument(
            id = task.id,
            name = task.name,
            dateTime = task.dateTime,
            description = task.description,
            location = task.location
        )
    }

    fun toTask(taskEntity: TaskDocument): Task {
        return Task(
            id = taskEntity.id,
            name = taskEntity.name,
            dateTime = taskEntity.dateTime,
            description = taskEntity.description,
            location = taskEntity.location
        )
    }
}