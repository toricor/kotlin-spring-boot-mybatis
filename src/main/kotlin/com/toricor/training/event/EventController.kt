package com.toricor.training.event

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

    @GetMapping("/search")
    fun getEventsByTitle(@RequestParam title: String): List<Event> =
            eventService.findByTitle(title)

    // インサートはOKしかし500 Error
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
}