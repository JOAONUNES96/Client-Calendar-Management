package com.flutteruki.calendar.management.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories

@SpringBootApplication(scanBasePackages = ["com.flutteruki.calendar.management"])
@EnableReactiveElasticsearchRepositories(basePackages = ["com.flutteruki.calendar.management.infrastructure.elastic"])
class ClientCalendarManagementApplication

fun main(args: Array<String>) {
	runApplication<ClientCalendarManagementApplication>(*args)
		println("hello")
}
