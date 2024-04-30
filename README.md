# Client-Calendar-Management
A Spring Boot application for managing client calendar events and tasks with Kafka integration and RESTful services.

## Overview

This project aims to develop a back-end application for managing calendar events and tasks related to clients. It leverages a microservices architecture with Kafka for messaging, Elasticsearch as a database and provides a RESTful API.

## Objective

The application will handle the creation and management of calendar items for clients, including:
- Real-time processing of client and task creation through Kafka messages.
- REST API for managing (create, read, delete) calendar items.
- Search capabilities powered by Elasticsearch database.

## Technologies

- **Spring Boot**: For creating the application framework.
- **Spring Data Elasticsearch**: For integrating Elasticsearch to enhance search functionality.
- **Apache Kafka**: For handling real-time data feeds.
- **Docker**: For running the necessary containers and the application

## Planned Features

- **Client Management**: Simple management of client identifiers.
- **Calendar Items**: Handling of events and tasks with essential attributes.
- **Real-time Updates**: Kafka consumers for client and task events.
- **Search and Pagination**: Utilizing Elasticsearch to search and paginate results efficiently, ordering by date.
- **System** The system must be non-bloking (from kafka consuption to BD interaction).
- **Local Deployment**: The application must use docker to run.
- **Future Deployment**: In the future the applications must be run in a distributed way.

## Current Status

The project is currently in the planning and setup phase. Specific functionalities and endpoints will be defined in the upcoming development cycles.

