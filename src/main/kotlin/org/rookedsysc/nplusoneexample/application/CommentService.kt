package org.rookedsysc.nplusoneexample.application

import jakarta.transaction.Transactional
import org.rookedsysc.nplusoneexample.application.converter.CommentConverter
import org.rookedsysc.nplusoneexample.domain.entity.Comment
import org.rookedsysc.nplusoneexample.domain.entity.Post
import org.rookedsysc.nplusoneexample.infrastructure.repository.CommentRepository
import org.rookedsysc.nplusoneexample.infrastructure.repository.PostRepository
import org.rookedsysc.nplusoneexample.infrastructure.web.request.CommentRequest
import org.rookedsysc.nplusoneexample.infrastructure.web.response.CommentResponse
import org.springframework.stereotype.Service

@Service
@Transactional
class CommentService(
    private val commentRepository: CommentRepository,
    private val postRepository: PostRepository
) {
    private val DUMMY_DATA: List<String> = listOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
        "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    )

    fun createDummy(request: CommentRequest, count: Int) {
        // Entity가 존재하지 않는 경우도 Proxy를 반환함
        // val post: Post = em.getReference(Post::class.java, 1L)
        val posts: List<Post> = postRepository.findAll()
        for (i in 1..count) {
            val dummyRequest = request.copyWith(DUMMY_DATA.random())
            commentRepository.save(CommentConverter.toEntity(dummyRequest, posts.random()))
        }
    }
}