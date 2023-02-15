package com.brendanr.demo.advice

import com.brendanr.demo.exception.InternalServerErrorException
import com.brendanr.demo.exception.NotFoundException
import com.brendanr.demo.model.api.ErrorResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.Instant

@ControllerAdvice
class BaseAdvice {

    /**
     * HTTP 404
     */
    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(e: Throwable?, req: HttpServletRequest) =
        handleException(NOT_FOUND, req)

    /**
     * HTTP 500
     */
    @ExceptionHandler(InternalServerErrorException::class)
    fun handleInternalServerError(e: Throwable?, req: HttpServletRequest) =
        handleException(INTERNAL_SERVER_ERROR, req)

    private fun handleException(httpStatus: HttpStatus, req: HttpServletRequest) =
        ResponseEntity
            .status(httpStatus.value())
            .contentType(APPLICATION_JSON)
            .body(
                ErrorResponse(
                    status = httpStatus.value(),
                    error = httpStatus.reasonPhrase,
                    timestamp = Instant.now(),
                    path = "${req.contextPath}${req.servletPath}"
                )
            )
}
