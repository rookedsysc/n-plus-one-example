package org.rookedsysc.nplusoneexample.application

import jakarta.transaction.Transactional
import org.rookedsysc.nplusoneexample.application.converter.PostConverter
import org.rookedsysc.nplusoneexample.domain.entity.Post
import org.rookedsysc.nplusoneexample.infrastructure.repository.PostRepository
import org.rookedsysc.nplusoneexample.infrastructure.web.request.PostRequest
import org.rookedsysc.nplusoneexample.infrastructure.web.response.PostResponse
import org.springframework.stereotype.Service

@Service
@Transactional
class PostService(
    private val postRepository: PostRepository
) {
    fun save(request: PostRequest): PostResponse {
        val post = PostConverter.toEntity(request)
        val response: PostResponse = PostConverter.toResponse(postRepository.save(post))
        return response
    }
}