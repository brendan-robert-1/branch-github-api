package com.brendanr.demo.exception

class InternalServerErrorException : RuntimeException {
    constructor(e: Throwable?, msg: () -> String?) : super(msg.invoke(), e)
    constructor(e: Throwable?) : super(e)
    constructor(msg: () -> String?) : super(msg.invoke())
    constructor() : super()
}