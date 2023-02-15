package com.brendanr.demo.service

import com.brendanr.demo.client.GithubUsersRestClient
import com.brendanr.demo.exception.InternalServerErrorException
import com.brendanr.demo.model.GithubUserResponseBuilder
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.kotlin.whenever
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest
@ExtendWith(SpringExtension::class)
class BranchGitServiceTest {

    @InjectMocks
    lateinit var service: BranchGitService

    @Mock
    lateinit var client: GithubUsersRestClient

    @Test
    fun `getUserDetails is successful`() {
        val username = "brendan"
        val response = GithubUserResponseBuilder(login = username).build()
        whenever(client.getGithubUserDetails(username)).thenReturn(response)
        val actual = service.getUserDetails(username)
        assertThat(actual.userName, `is`(username))
        assertThat(actual.avatarUrl, `is`(response.avatarUrl))
        assertThat(actual.email, `is`(response.email))
        assertThat(actual.url, `is`(response.url))
        assertThat(actual.geoLocation, `is`(response.location))
        assertThat(actual.displayName, `is`(response.name))
    }

    @Test
    fun `getUserDetails and failed to get user details InternalServerErrorException is thrown`() {
        val username = "brendan"
        whenever(client.getGithubUserDetails(username)).thenThrow(RuntimeException())
        assertThrows<InternalServerErrorException> {
            service.getUserDetails(username)
        }
    }

    @Test
    fun `getUserDetails and failed to get user repo details InternalServerErrorException is thrown`() {
        val username = "brendan"
        val response = GithubUserResponseBuilder(login = username).build()
        whenever(client.getGithubUserDetails(username)).thenReturn(response)
        whenever(client.getGithubRepoDetails(username)).thenThrow(RuntimeException())
        assertThrows<InternalServerErrorException> {
            service.getUserDetails(username)
        }
    }
}
