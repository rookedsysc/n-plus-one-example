package org.rookedsysc.nplusoneexample.infrastructure.web

import org.rookedsysc.nplusoneexample.application.PostService
import org.rookedsysc.nplusoneexample.infrastructure.web.request.PostRequest
import org.rookedsysc.nplusoneexample.infrastructure.web.response.PostResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/posts")
class PostController(
    private val postService: PostService,
) {
    @PostMapping
    fun save(@RequestBody request: PostRequest): ResponseEntity<PostResponse> {
        val response: PostResponse = postService.save(request)
        return ResponseEntity<PostResponse>(
            response,
            HttpStatus.CREATED
        )
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<PostResponse> {
        val response: PostResponse = postService.findById(id)
        return ResponseEntity<PostResponse>(
            response,
            HttpStatus.OK
        )
    }
}