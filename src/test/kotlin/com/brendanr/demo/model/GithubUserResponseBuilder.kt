package com.brendanr.demo.model

import com.brendanr.demo.model.rest.GithubUserResponse
import java.time.LocalDateTime
import java.util.*

data class GithubUserResponseBuilder(
    val login: String = UUID.randomUUID().toString(),
    val name: String = UUID.randomUUID().toString(),
    val avatarUrl: String = UUID.randomUUID().toString(),
    val location: String = UUID.randomUUID().toString(),
    val email: String? = UUID.randomUUID().toString(),
    val url: String = UUID.randomUUID().toString(),
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun build() =
        GithubUserResponse(
            login = login,
            name = name,
            avatarUrl = avatarUrl,
            location = location,
            email = email,
            url = url,
            createdAt = createdAt
        )
}
