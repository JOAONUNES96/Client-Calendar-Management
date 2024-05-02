package com.flutteruki.calendar.management.application

import com.flutteruki.calendar.management.domain.model.Event
import com.flutteruki.calendar.management.infrastructure.adapters.EventRepositoryAdapter
import com.flutteruki.calendar.management.infrastructure.elastic.EventRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ConfigurableApplicationContext
import java.time.LocalDateTime
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories


@SpringBootApplication(scanBasePackages = ["com.flutteruki.calendar.management"])
@EnableReactiveElasticsearchRepositories(basePackages = ["com.flutteruki.calendar.management.infrastructure.elastic"])
class ClientCalendarManagementApplication

fun main(args: Array<String>) {
	runApplication<ClientCalendarManagementApplication>(*args)
		println("hello")
}
