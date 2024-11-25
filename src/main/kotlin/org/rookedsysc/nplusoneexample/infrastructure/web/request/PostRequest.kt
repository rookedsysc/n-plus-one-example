package org.rookedsysc.nplusoneexample.infrastructure.web.request

data class PostRequest (
    val userId: Long,
    val title: String,
    val content: String,
    val author: String,
)
