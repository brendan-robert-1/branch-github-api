package com.brendanr.demo.extensions

import com.brendanr.demo.model.api.BranchGithubRepositories
import com.brendanr.demo.model.api.BranchUserResponse
import com.brendanr.demo.model.rest.GithubUserRepositoriesResponse
import com.brendanr.demo.model.rest.GithubUserResponse

fun GithubUserResponse.toBranchApiModel(repos: List<BranchGithubRepositories>) =
    BranchUserResponse(
        userName = this.login,
        displayName = this.name,
        avatarUrl = this.avatarUrl,
        geoLocation = this.location,
        email = this.email,
        url = this.url,
        createdAt = this.createdAt,
        repos = repos
    )

fun List<GithubUserRepositoriesResponse>.toBranchApiModel(): List<BranchGithubRepositories> =
    this.map {
        BranchGithubRepositories(
            name = it.name,
            url = it.url
        )
    }.toList()