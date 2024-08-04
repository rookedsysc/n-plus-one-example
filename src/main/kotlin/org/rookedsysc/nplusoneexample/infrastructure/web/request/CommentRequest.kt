package org.rookedsysc.nplusoneexample.infrastructure.web.request

data class CommentRequest (
    val content: String,
    val author: String
) {
    fun copyWith(content: String?): CommentRequest {
        return CommentRequest(
            content = content ?: this.content,
            author = this.author
        )
    }
}