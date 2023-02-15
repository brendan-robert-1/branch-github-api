package com.brendanr.demo.extensions

import com.brendanr.demo.model.api.BranchGithubRepositories
import com.brendanr.demo.model.api.BranchUserResponse
import com.brendanr.demo.model.rest.GithubUserRepositoriesResponse
import com.brendanr.demo.model.rest.GithubUserResponse

/**
 * Used to convert user response from github rest client model to api model
 */
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

/**
 * Used to convert user repo response from github rest client model to api model
 */
fun List<GithubUserRepositoriesResponse>.toBranchApiModel(): List<BranchGithubRepositories> =
    this.map {
        BranchGithubRepositories(
            name = it.name,
            url = it.url
        )
    }.toList()
