package com.github.it.springtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class SpringTestApplication {

    @RequestMapping("/asdf")
    fun sans(): String {
        return "asdlkfajsdfkl;j"
    }
}

fun main(args: Array<String>) {
    runApplication<SpringTestApplication>(*args)
}
