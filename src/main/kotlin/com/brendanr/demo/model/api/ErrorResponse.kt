package com.brendanr.demo.model.api

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import java.time.Instant

@JsonInclude(NON_NULL)
data class ErrorResponse(
    val status: Int?,

    val error: String?,

    val timestamp: Instant?,

    val path: String?
)
