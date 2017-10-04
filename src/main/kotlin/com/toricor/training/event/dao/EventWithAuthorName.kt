package com.toricor.training.event.dao

import org.joda.time.DateTime
import java.sql.Timestamp

data class EventWithAuthorName (
        val id: Int,
        var title: String,
        var description: String,
        var author: String,
        var place: String,
        var participants: String,
        var max_participants: String,
        val created_at: Timestamp,
        var published_at: Timestamp
) {
    val remaining = max_participants.toInt() - participants.toInt()
}