package com.brendanr.demo.model

import com.brendanr.demo.model.api.BranchGithubRepositories
import com.brendanr.demo.model.api.BranchUserResponse
import java.time.LocalDateTime
import java.util.*

data class BranchUserResponseBuilder(
    val userName: String = UUID.randomUUID().toString(),
    val displayName: String = UUID.randomUUID().toString(),
    val avatarUrl: String = UUID.randomUUID().toString(),
    val geoLocation: String = UUID.randomUUID().toString(),
    val email: String? = UUID.randomUUID().toString() + "@gmail.com",
    val url: String = UUID.randomUUID().toString(),
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val repos: List<BranchGithubRepositories> = listOf(BranchGithubRepositoriesBuilder().build())
) {
    fun build() =
        BranchUserResponse(
            userName = userName,
            displayName = displayName,
            avatarUrl = avatarUrl,
            geoLocation = geoLocation,
            email = email,
            url = url,
            createdAt = createdAt,
            repos = repos
        )
}

data class BranchGithubRepositoriesBuilder(
    val name: String = UUID.randomUUID().toString(),
    val url: String = UUID.randomUUID().toString()
) {
    fun build() =
        BranchGithubRepositories(
            name = name,
            url = url
        )
}
