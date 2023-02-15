package com.brendanr.demo.model.api

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime,

    val repos: List<BranchGithubRepositories>
)
