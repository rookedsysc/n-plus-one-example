package org.rookedsysc.nplusoneexample.infrastructure.web

import org.rookedsysc.nplusoneexample.application.MemberService
import org.rookedsysc.nplusoneexample.domain.entity.Member
import org.rookedsysc.nplusoneexample.infrastructure.web.request.MemberRequest
import org.rookedsysc.nplusoneexample.infrastructure.web.response.MemberResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/members")
class MemberController(
    private val memberService: MemberService
) {
    @PostMapping
    fun save(@RequestBody memberRequest:MemberRequest): ResponseEntity<Member> {
        val response: Member = memberService.create(memberRequest)
        return ResponseEntity<Member>(
            response,
            HttpStatus.CREATED
        )
    }

    @GetMapping("/{id}")
    fun getMember(@RequestParam("id") id: Long): ResponseEntity<MemberResponse> {
        val response: MemberResponse = memberService.getMember(id)
        return ResponseEntity<MemberResponse>(
            response,
            HttpStatus.OK
        )
    }
}
