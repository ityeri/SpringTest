package com.github.it.springtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class SpringTestApplication {

    @RequestMapping("/")
    fun home(): String {
        return "Hello Spring Test"
    }

    @RequestMapping("/wasans")
    fun sans(): String {
        return "와 파피루스"
    }
}

fun main(args: Array<String>) {
    runApplication<SpringTestApplication>(*args)
}
