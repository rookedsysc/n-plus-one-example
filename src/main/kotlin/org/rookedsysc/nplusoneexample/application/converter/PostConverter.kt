package org.rookedsysc.nplusoneexample.application.converter

import org.rookedsysc.nplusoneexample.domain.entity.Post
import org.rookedsysc.nplusoneexample.infrastructure.web.request.PostRequest
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

        fun toResponse(entity: Post): PostResponse {
            return PostResponse(
                id = entity.id!!,
                title = entity.title,
                content = entity.content,
                author = entity.author
            )
        }
    }
}