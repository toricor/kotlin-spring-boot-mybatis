package com.toricor.training.event.dao

data class Event (
    val id: Int,
    var title: String,
    var description: String,
    val datetime: java.sql.Timestamp,
    var publish: java.sql.Timestamp,
    var author: Int,
    var place: String,
    var participants: String,
    var max_participants: String
)
