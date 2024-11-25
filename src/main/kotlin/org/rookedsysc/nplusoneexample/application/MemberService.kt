package org.rookedsysc.nplusoneexample.application

import jakarta.transaction.Transactional
import org.rookedsysc.nplusoneexample.application.converter.MemberConverter
import org.rookedsysc.nplusoneexample.domain.entity.Member
import org.rookedsysc.nplusoneexample.infrastructure.repository.MemberRepository
import org.rookedsysc.nplusoneexample.infrastructure.web.request.MemberRequest
import org.rookedsysc.nplusoneexample.infrastructure.web.response.MemberResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
@Transactional
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun create(memberRequest: MemberRequest): Member {
        val member: Member = MemberConverter.toEntity(memberRequest)
        return memberRepository.save(member)
    }

    fun getMember(id:Long): MemberResponse {
        val members: Member = memberRepository.findById(id).orElseThrow{
            throw IllegalArgumentException("user id ${id}를 찾을 수 없습니다.")
        }
        return MemberConverter.toResponse(members)
    }
}
