package com.brendanr.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BranchGithubApiApplication

fun main(args: Array<String>) {
    runApplication<BranchGithubApiApplication>(*args)
}
