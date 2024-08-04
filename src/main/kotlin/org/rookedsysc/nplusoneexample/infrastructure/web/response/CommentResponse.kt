package org.rookedsysc.nplusoneexample.infrastructure.web.response

data class CommentResponse (
    val id: Long,
    val content: String,
    val author: String
)