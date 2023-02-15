package com.brendanr.demo.controller

import com.brendanr.demo.service.BranchGitService
import org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class BranchGitController(
    private val branchGitService: BranchGitService
) {
    @GetMapping(
        path = ["/{username}"],
        produces = [APPLICATION_JSON_VALUE]
    )
    fun getUserDetails(
        @PathVariable("username") username: String
    ) = branchGitService.getUserDetails(username)
}
