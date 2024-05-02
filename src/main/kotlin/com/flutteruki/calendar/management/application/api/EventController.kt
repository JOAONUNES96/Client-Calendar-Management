package com.flutteruki.calendar.management.application.api

import com.flutteruki.calendar.management.domain.model.Event
import com.flutteruki.calendar.management.domain.ports.EventRepositoryPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/events")
class EventController @Autowired constructor(
    private val eventRepository: EventRepositoryPort
) {

    //The purpose of the app is to upsert information using kafka messages, however I added this endpoint to test the application
    @PostMapping
    suspend fun addEvent(@RequestBody event: Event): ResponseEntity<String> {
        return try {
            eventRepository.save(event)
            ResponseEntity.ok("Event added successfully")
        } catch (e: Exception) {
            ResponseEntity.internalServerError().body("Failed to add event: ${e.message}")
        }
    }
}
/*
To test this endpoint you can use the following curl command:

curl -X POST -H "Content-Type: application/json" -d '{
   "id": "2",
   "name": "Evento de teste",
   "dateTime": "2024-05-02T13:56:11",
   "description": "Este é um evento de teste",
   "location": "Localização de teste",
   "participants": []
}' http://localhost:8080/api/events
*/
