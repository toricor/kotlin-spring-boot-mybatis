package com.toricor.training.event.dao

import org.joda.time.DateTime
import java.sql.Timestamp

data class Event (
        val id: Int,
        var title: String,
        var description: String,
        var author: Int,
        var place: String,
        var participants: Int,
        var max_participants: Int,
        val created_at: Timestamp,
        var published_at: Timestamp
) {
    val remaining = max_participants - participants
}
