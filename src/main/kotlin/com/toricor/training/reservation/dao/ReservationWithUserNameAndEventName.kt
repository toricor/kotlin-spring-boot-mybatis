package com.toricor.training.reservation.dao

data class ReservationWithUserNameAndEventName (
    val id: Int,
    val userName: String = "",
    val eventName: String = ""
)