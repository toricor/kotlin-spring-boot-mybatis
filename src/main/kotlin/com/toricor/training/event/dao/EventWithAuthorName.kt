package com.toricor.training.event.dao

import org.joda.time.DateTime
import java.sql.Timestamp

data class EventWithAuthorName (
        val id: Int,
        var title: String,
        var description: String,
        var author: String,
        var place: String,
        var participants: Int,
        var maxParticipants: Int,
        val createdAt: Timestamp,
        var publishedAt: Timestamp
    // 先にDBを最新版に更新すること
) {
    val remaining = maxParticipants - participants
}