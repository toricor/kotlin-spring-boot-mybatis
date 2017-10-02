package com.toricor.training.event

import java.sql.Timestamp
import java.util.Date

data class Event (
    val id: Int,
    var title: String,
    var description: String,
    val datetime: Timestamp,
    var publish: Timestamp,
    var author: Int,
    var place: String,
    var participants: String,
    var max_participants: String
)
