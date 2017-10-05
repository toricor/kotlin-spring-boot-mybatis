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
        var maxParticipants: Int,
        val createdAt: Timestamp,
        var publishedAt: Timestamp
) {
    val remaining = maxParticipants - participants
}
