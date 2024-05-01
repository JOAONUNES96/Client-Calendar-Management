package com.flutteruki.calendar.management.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ClientCalendarManagementApplication

fun main(args: Array<String>) {
	runApplication<ClientCalendarManagementApplication>(*args)
		println("hello")
}
