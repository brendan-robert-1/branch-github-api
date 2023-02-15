package com.brendanr.demo.service

import com.brendanr.demo.client.GithubUsersRestClient
import com.brendanr.demo.exception.InternalServerErrorException
import com.brendanr.demo.extensions.toBranchApiModel
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class BranchGitService(
    private val githubUsersRestClient: GithubUsersRestClient
) {

    private val logger = KotlinLogging.logger {}

    /**
     * Gets the user details from the GitHub user REST api
     *
     * @param [username] to fetch GitHub details for
     * @throws [IllegalArgumentException] when failed to get user details
     */
    @Throws(InternalServerErrorException::class)
    fun getUserDetails(username: String) =
        try {
            githubUsersRestClient
                .getGithubUserDetails(username)
                .toBranchApiModel(getUserRepos(username))
        } catch (e: Exception) {
            "Failed to get user details for: $username".let {
                logger.error(e) { it }
                throw InternalServerErrorException(e) { it }
            }
        }

    /**
     * Gets the repo details from the GitHub user REST api
     *
     * @param [username] to fetch GitHub repo details for
     * @throws [IllegalArgumentException] when failed to get user details
     */
    @Throws(InternalServerErrorException::class)
    private fun getUserRepos(username: String) =
        try {
            githubUsersRestClient
                .getGithubRepoDetails(username)
                .toBranchApiModel()
        } catch (e: Exception) {
            "Failed to get user details for: $username".let {
                logger.error(e) { it }
                throw InternalServerErrorException(e) { it }
            }
        }
}
