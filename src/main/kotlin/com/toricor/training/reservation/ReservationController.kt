package com.toricor.training.reservation

import com.toricor.training.reservation.dao.Reservation
import com.toricor.training.reservation.dao.ReservationWithUserNameAndEventName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/reservations")
class ReservationController {

    @Autowired
    lateinit var reservationService: ReservationService

    @GetMapping
    fun getReservations(): List<Reservation> =
            reservationService.findAll()

    @GetMapping("/joined")
    fun getReservationWithUserNameAndEventName(): List<ReservationWithUserNameAndEventName> =
            reservationService.findAllWithUserNameAndEventName()

    @GetMapping("{id}")
    fun getReservation(@PathVariable id: Int): Reservation =
            reservationService.findOne(id)


}