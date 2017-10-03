package com.toricor.training.event.dao

import org.joda.time.DateTime
import java.sql.Timestamp

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
) {
    val remaining = max_participants.toInt() - participants.toInt()
}
