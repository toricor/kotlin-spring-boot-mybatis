package com.toricor.training.event

import com.toricor.training.event.dao.Event
import com.toricor.training.event.dao.EventWithAuthorName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/events")
class EventController {

    @Autowired
    lateinit var eventService: EventService

    @GetMapping
    fun getEvents(): List<Event> =
            eventService.findAll()

    @GetMapping("{id}")
    fun getEvent(@PathVariable id: Int): Event =
            eventService.findOne(id)

    @GetMapping("/joined")
    fun getEventsWithAuthorName(): List<EventWithAuthorName> =
            eventService.findAllWithAuthorName()

    @GetMapping("/search")
    fun getEventsByTitle(@RequestParam title: String): List<Event> =
            eventService.findByTitle(title)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createEvent(@RequestBody event: Event): Event =
            eventService.create(event)

    @PostMapping("{id}")
    fun updateEvent(@PathVariable id: Int, @RequestBody event: Event): Event {
        return eventService.update(event)
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteEvent(@PathVariable id: Int) {
        eventService.delete(id)
    }

    @GetMapping("/remaining/{id}")
    fun getRemaining(@PathVariable id: Int): Int =
        eventService.findOne(id).remaining
}