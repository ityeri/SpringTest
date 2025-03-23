package com.github.it.springtest.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class TestController {
    @GetMapping("/test")
    fun test(model: Model): Model {
        model.addAttribute("message", "Hello Spring Test")
        return model
    }
}