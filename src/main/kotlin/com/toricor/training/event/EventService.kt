package com.toricor.training.event

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EventService {

    @Autowired
    lateinit var EventRepository: EventRepository

    fun findAll(): List<Event> =
            EventRepository.findAll()


    fun findOne(id: Int): Event =
            EventRepository.findOne(id)


    fun findByTitle(title: String): List<Event> =
            EventRepository.findByTitle(title)


    fun create(event: Event): Event {
        EventRepository.insert(event)
        return event
    }

    fun update(event: Event): Event {
        EventRepository.update(event)
        return event
    }

    fun delete(id: Int) {
        EventRepository.delete(id)
    }

}