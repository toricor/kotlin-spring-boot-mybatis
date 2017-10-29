package com.toricor.training.reservation

import com.toricor.training.reservation.dao.Reservation
import com.toricor.training.reservation.dao.ReservationWithUserNameAndEventName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/reservations")
class ReservationController {

    @Autowired
    lateinit var reservationService: ReservationService

    @GetMapping
    fun getReservations(): List<Reservation> {
        reservationService.findAll()
    }

    @GetMapping("/joined")
    fun getReservationWithUserNameAndEventName(): List<ReservationWithUserNameAndEventName> {
        reservationService.findAllWithUserNameAndEventName()
    }

    @GetMapping("{id}")
    fun getReservation(@PathVariable id: Int): Reservation {
        reservationService.findOne(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody reservation: Reservation) {
        reservationService.create(reservation)
    }

    @PostMapping("{id}")
    fun updateUser(@PathVariable id: Int, @RequestBody reservation: Reservation) {
        reservationService.update(reservation)
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Int) {
        reservationService.delete(id)
    }

}