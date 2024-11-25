package org.rookedsysc.nplusoneexample.application.converter

import org.rookedsysc.nplusoneexample.domain.entity.Member
import org.rookedsysc.nplusoneexample.infrastructure.web.request.MemberRequest
import org.rookedsysc.nplusoneexample.infrastructure.web.response.CommentResponse
import org.rookedsysc.nplusoneexample.infrastructure.web.response.MemberResponse

class MemberConverter {
    companion object {
        fun toEntity(memberRequest: MemberRequest): Member {
            return Member(
                name = memberRequest.name,
                passwd = memberRequest.passwd
            )
        }

        fun toResponse(member: Member): MemberResponse {
            return MemberResponse(
                id = member.id!!,
                name = member.name,
                posts = member.posts.map { post ->
                    val comments: List<CommentResponse> = CommentConverter.toResponses(post.comments)
                    PostConverter.toResponse(post, comments)
                }
            )
        }
    }
}
