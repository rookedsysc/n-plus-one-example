package org.rookedsysc.nplusoneexample.domain.entity

import jakarta.persistence.*

@Entity(name = "member")
@NamedEntityGraph(
    name = "Member.posts",
    attributeNodes = [
        NamedAttributeNode(value = "posts", subgraph = "post-comments")
    ],
    subgraphs = [
        NamedSubgraph(
            name = "post-comments",
            attributeNodes = [
                NamedAttributeNode("comments")
            ]
        ),
    ]
)
class Member(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val passwd: String,
    @field:OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    val posts: List<Post> = listOf()
) {}
