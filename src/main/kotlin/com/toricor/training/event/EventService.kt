package com.toricor.training.event

import com.toricor.training.event.dao.Event
import com.toricor.training.event.dao.EventWithAuthorName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EventService {

    @Autowired
    lateinit var eventRepository: EventRepository

    fun findAll(): List<Event> = eventRepository.findAll()


    fun findOne(id: Int): Event = eventRepository.findOne(id)

    fun findAllWithAuthorName(): List<EventWithAuthorName> = eventRepository.findAllWithAuthorName()

    fun findByTitle(title: String): List<Event> = eventRepository.findByTitle(title)


    fun create(event: Event): Event {
        eventRepository.insert(event)
        return event
    }

    fun update(event: Event): Event {
        eventRepository.update(event)
        return event
    }

    fun delete(id: Int) = eventRepository.delete(id)

}