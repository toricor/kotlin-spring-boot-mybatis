package com.toricor.training.reservation

import com.toricor.training.reservation.dao.Reservation
import com.toricor.training.reservation.dao.ReservationWithUserNameAndEventName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class ReservationService {

    @Autowired
    lateinit var reservationRepository: ReservationRepository

    fun findAll(): List<Reservation> {
        reservationRepository.findAll()
    }

    fun findOne(id: Int): Reservation {
        reservationRepository.findOne(id)
    }

    fun findAllWithUserNameAndEventName(): List<ReservationWithUserNameAndEventName> {
        reservationRepository.findAllWithUserNameAndEventName()
    }
    fun create(reservation: Reservation){
        reservationRepository.insert(reservation)
    }

    fun update(reservation: Reservation){
        reservationRepository.update(reservation)
    }

    fun delete(id: Int) = reservationRepository.delete(id)
}