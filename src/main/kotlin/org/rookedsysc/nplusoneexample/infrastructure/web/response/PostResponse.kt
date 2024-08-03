package org.rookedsysc.nplusoneexample.infrastructure.web.response

data class PostResponse (
    val id: Long,
    val title: String,
    val content: String,
    val author: String
)