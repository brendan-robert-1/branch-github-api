package com.brendanr.demo.model.rest

import com.fasterxml.jackson.annotation.JsonAlias

data class GithubUserRepositoriesResponse(
    val name: String,

    @JsonAlias("html_url")
    val url: String
)