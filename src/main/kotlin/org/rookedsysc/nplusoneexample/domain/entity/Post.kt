package org.rookedsysc.nplusoneexample.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.BatchSize

@Entity(name = "post")
data class Post (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val content: String,
    val author: String,
    @field:OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    val comments: List<Comment> = listOf()
)