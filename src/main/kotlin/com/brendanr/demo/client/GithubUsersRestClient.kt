package com.brendanr.demo.client

import com.brendanr.demo.model.rest.GithubUserRepositoriesResponse
import com.brendanr.demo.model.rest.GithubUserResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod.GET
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.util.UriComponentsBuilder

@Component
class GithubUsersRestClient(
    @Value("\${github.url}")
    private val GITHUB_USER_HOST: String
) {

    private val restTemplate: RestTemplate = RestTemplateBuilder().build()

    protected fun githubUserUrl(username: String) =
        UriComponentsBuilder.fromHttpUrl(GITHUB_USER_HOST)
            .path("/{userName}")
            .buildAndExpand(username)
            .toUriString()

    fun getGithubUserDetails(username:String) =
        restTemplate.getForEntity(
            githubUserUrl(username),
            GithubUserResponse::class.java
        ).body!!

    protected fun githubReposUrl(username: String) =
        UriComponentsBuilder.fromHttpUrl(GITHUB_USER_HOST)
            .path("/{userName}")
            .path("/repos")
            .buildAndExpand(username)
            .toUriString()

    fun getGithubRepoDetails(username: String): List<GithubUserRepositoriesResponse> =
        restTemplate.exchange(
            githubReposUrl(username),
            GET,
            HttpEntity.EMPTY,
            object: ParameterizedTypeReference<List<GithubUserRepositoriesResponse>>(){}
        ).body!!
}