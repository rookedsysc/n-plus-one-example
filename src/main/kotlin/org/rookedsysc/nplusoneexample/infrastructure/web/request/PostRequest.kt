package org.rookedsysc.nplusoneexample.infrastructure.web.request

data class PostRequest (
    val title: String,
    val content: String,
    val author: String
)