package org.rookedsysc.nplusoneexample.infrastructure.repository

import org.rookedsysc.nplusoneexample.domain.entity.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface PostRepository: JpaRepository<Post, Long> {
    @Query("SELECT p FROM post p JOIN FETCH p.comments")
    fun findAllPostFetchJoinComments(): List<Post>
}