package org.rookedsysc.nplusoneexample.infrastructure.web

import org.rookedsysc.nplusoneexample.application.CommentService
import org.rookedsysc.nplusoneexample.infrastructure.web.request.CommentRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/comments")
class CommentController(
    private val commentService: CommentService
) {

    @PostMapping("/{count}/dummy")
    fun createDummy(
        @PathVariable(name = "count") count: Int,
        @RequestBody request: CommentRequest
    ) : ResponseEntity<Unit> {
        commentService.createDummy(request, count)
        return ResponseEntity(
            HttpStatus.CREATED
        )
    }
}