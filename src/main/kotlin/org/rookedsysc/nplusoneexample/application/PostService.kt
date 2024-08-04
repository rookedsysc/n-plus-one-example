package org.rookedsysc.nplusoneexample.application

import jakarta.transaction.Transactional
import org.rookedsysc.nplusoneexample.application.converter.CommentConverter
import org.rookedsysc.nplusoneexample.application.converter.PostConverter
import org.rookedsysc.nplusoneexample.domain.entity.Comment
import org.rookedsysc.nplusoneexample.domain.entity.Post
import org.rookedsysc.nplusoneexample.infrastructure.repository.CommentRepository
import org.rookedsysc.nplusoneexample.infrastructure.repository.PostRepository
import org.rookedsysc.nplusoneexample.infrastructure.web.request.PostRequest
import org.rookedsysc.nplusoneexample.infrastructure.web.response.CommentResponse
import org.rookedsysc.nplusoneexample.infrastructure.web.response.PostResponse
import org.springframework.stereotype.Service

@Service
@Transactional
class PostService(
    private val postRepository: PostRepository,
    private val commentRepository: CommentRepository
) {
    fun save(request: PostRequest): PostResponse {
        val post = PostConverter.toEntity(request)
        val response: PostResponse = PostConverter.toResponse(postRepository.save(post))
        return response
    }

    fun findById(id: Long): PostResponse {
        val post: Post = postRepository.findById(id).orElseThrow { IllegalArgumentException("Post not found: $id") }
        val comments: List<CommentResponse> = commentRepository.findByPostId(post.id!!).map { CommentConverter.toResponse(it) }
        return PostConverter.toResponse(post, comments)
    }

    fun findAll(): List<Post> {
        return postRepository.findAll()
    }
}