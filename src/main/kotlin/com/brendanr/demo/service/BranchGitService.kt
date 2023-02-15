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
            logger.debug {"Getting user details for: $username"}
            githubUsersRestClient
                .getGithubUserDetails(username)
                .toBranchApiModel(getUserRepos(username)).also{logger.info {"Finished getting user details for: $username"}}
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
            logger.debug {"Getting user repo details for: $username"}
            githubUsersRestClient
                .getGithubRepoDetails(username)
                .toBranchApiModel().also{logger.info {"Finished getting user repo details for: $username"}}
        } catch (e: Exception) {
            "Failed to get user details for: $username".let {
                logger.error(e) { it }
                throw InternalServerErrorException(e) { it }
            }
        }
}
