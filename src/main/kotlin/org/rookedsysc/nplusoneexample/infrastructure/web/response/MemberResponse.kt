package org.rookedsysc.nplusoneexample.infrastructure.web.response

data class MemberResponse(
    val id: Long,
    val name: String,
    val posts: List<PostResponse>
)
