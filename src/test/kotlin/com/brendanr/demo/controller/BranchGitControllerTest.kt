package com.brendanr.demo.controller

import com.brendanr.demo.exception.InternalServerErrorException
import com.brendanr.demo.model.BranchUserResponseBuilder
import com.brendanr.demo.service.BranchGitService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
class BranchGitControllerTest(
    @Autowired val mockMvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper
) {
    @MockBean
    lateinit var branchGitService: BranchGitService

    @Test
    fun `test when successful 200 is returned`() {
        val username = "brendan"
        val response = BranchUserResponseBuilder(userName = username).build()
        whenever(branchGitService.getUserDetails(username)).thenReturn(response)
        mockMvc.perform(get("/$username"))
            .andExpect(status().isOk)
            .andExpect(content().json(objectMapper.writeValueAsString(response)))
    }

    @Test
    fun `test when error 500 is returned`() {
        val username = "brendan"
        whenever(branchGitService.getUserDetails(username)).thenThrow(InternalServerErrorException())
        mockMvc.perform(get("/$username"))
            .andExpect(status().isInternalServerError)
    }
}
