package org.rookedsysc.nplusoneexample.domain.entity

import jakarta.persistence.*

@Entity(name = "comment")
data class Comment (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val content: String,
    val author: String,
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "post_id", nullable = false)
    val post: Post,
)
