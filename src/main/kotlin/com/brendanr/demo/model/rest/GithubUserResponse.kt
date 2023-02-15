package com.brendanr.demo.model.rest

import com.fasterxml.jackson.annotation.JsonAlias
import java.time.LocalDateTime

data class GithubUserResponse(
    val login: String,

    val name: String,

    @JsonAlias("avatar_url")
    val avatarUrl: String,

    val location: String,

    val email: String?,

    @JsonAlias("html_url")
    val url: String,

    @JsonAlias("created_at")
    val createdAt: LocalDateTime
)
