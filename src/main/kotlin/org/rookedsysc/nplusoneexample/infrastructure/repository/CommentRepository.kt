package org.rookedsysc.nplusoneexample.infrastructure.repository

import org.rookedsysc.nplusoneexample.domain.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
    fun findByPostId(postId: Long): List<Comment>
}
