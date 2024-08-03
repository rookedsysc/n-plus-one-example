package org.rookedsysc.nplusoneexample.infrastructure.repository

import org.rookedsysc.nplusoneexample.domain.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post, Long>