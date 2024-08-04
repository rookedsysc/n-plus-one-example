package org.rookedsysc.nplusoneexample.application.converter

import org.rookedsysc.nplusoneexample.domain.entity.Comment
import org.rookedsysc.nplusoneexample.domain.entity.Post
import org.rookedsysc.nplusoneexample.infrastructure.web.request.CommentRequest
import org.rookedsysc.nplusoneexample.infrastructure.web.response.CommentResponse

class CommentConverter {
    companion object {
        fun toEntity(request: CommentRequest, post: Post): Comment {
            return Comment(
                author = request.author,
                post = post,
                content = request.content
            )
        }

        fun toResponse(comment: Comment): CommentResponse {
            return CommentResponse(
                id = comment.id!!,
                content = comment.content,
                author = comment.author
            )
        }

        fun toResponses(comments: List<Comment>): List<CommentResponse> {
            return comments.map { toResponse(it) }
        }
    }
}
