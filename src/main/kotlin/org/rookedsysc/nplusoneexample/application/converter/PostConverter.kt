package org.rookedsysc.nplusoneexample.application.converter

import org.rookedsysc.nplusoneexample.domain.entity.Post
import org.rookedsysc.nplusoneexample.infrastructure.web.request.PostRequest
import org.rookedsysc.nplusoneexample.infrastructure.web.response.CommentResponse
import org.rookedsysc.nplusoneexample.infrastructure.web.response.PostResponse

class PostConverter {
    companion object {
        fun toEntity(request: PostRequest): Post {
            return Post(
                title = request.title,
                content = request.content,
                author = request.author
            )
        }

        fun toResponse(entity: Post, comments: List<CommentResponse>): PostResponse {
            return PostResponse(
                id = entity.id!!,
                title = entity.title,
                content = entity.content,
                author = entity.author,
                comments = comments
            )
        }

        fun toResponse(entity: Post): PostResponse {
            return PostResponse(
                id = entity.id!!,
                title = entity.title,
                content = entity.content,
                author = entity.author,
                comments = mutableListOf()
            )
        }

        fun toResponseUseRepository(post: Post): PostResponse {
            return PostResponse(
                id = post.id!!,
                title = post.title,
                content = post.content,
                author = post.author,
                comments = post.comments.map { CommentConverter.toResponse(it) }
            )
        }
    }
}