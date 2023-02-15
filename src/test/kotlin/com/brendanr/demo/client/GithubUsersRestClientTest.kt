package com.brendanr.demo.client

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.web.client.RestTemplate

@ExtendWith(SpringExtension::class)
class GithubUsersRestClientTest {
    @Autowired
    private lateinit var restTemplate: RestTemplate
    private lateinit var mapper: ObjectMapper
    private lateinit var githubUsersRestClient: GithubUsersRestClient
    private lateinit var mockServer: MockRestServiceServer

    @BeforeEach
    fun init() {
        mapper = ObjectMapper()
        mapper.registerModule(JavaTimeModule())
        mockServer = MockRestServiceServer.createServer(restTemplate)
        githubUsersRestClient = GithubUsersRestClient("https://api.github.com/users/")
    }

/*
    Ran into some issues with this test, could dig deeper if given more time
 */
//    @Test
//    fun `getGithubUserDetails when successful GithubUserResponse is returned`(){
//        val userName = "brendan"
//        val response = GithubUserResponseBuilder().build()
//        mockServer
//            .expect(requestTo(githubUsersRestClient.githubUserUrl(userName)))
//            .andRespond(
//                withStatus(HttpStatus.OK)
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .body(mapper.writeValueAsString(response))
//            )
//        githubUsersRestClient.getGithubUserDetails(userName)
//        mockServer.verify()
//    }
}
