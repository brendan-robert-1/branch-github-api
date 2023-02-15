package com.brendanr.demo.model.api

import com.brendanr.demo.model.rest.GithubUserRepositoriesResponse
import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty

data class BranchUserResponse(
    @JsonProperty("user_name")
    val userName: String,

    @JsonProperty("display_name")
    val displayName: String,

    @JsonProperty("avatar")
    val avatarUrl: String,

    @JsonProperty("geo_location")
    val geoLocation: String,

    val email: String?,

    val url: String,

    @JsonProperty("created_at")
    val createdAt: String,

    val repos: List<BranchGithubRepositories>
)
