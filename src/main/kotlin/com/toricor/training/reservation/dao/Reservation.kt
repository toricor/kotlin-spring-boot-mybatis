package com.toricor.training.reservation.dao

data class Reservation (
    val id: Int,
    val userId: Int = 0,
    val eventId: Int = 0
)