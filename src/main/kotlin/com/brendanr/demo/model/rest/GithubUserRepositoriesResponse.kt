package com.brendanr.demo.model.rest

import com.fasterxml.jackson.annotation.JsonProperty

data class GithubUserRepositoriesResponse(
    val name: String,

    @JsonProperty("html_url")
    val url: String
)
