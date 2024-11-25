package org.rookedsysc.nplusoneexample.infrastructure.repository

import org.rookedsysc.nplusoneexample.domain.entity.Member
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface MemberRepository : JpaRepository<Member, Long> {
    @EntityGraph(value = "Member.posts", type = EntityGraph.EntityGraphType.LOAD)
    override fun findById(id: Long): Optional<Member>
}
