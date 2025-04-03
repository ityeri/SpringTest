package com.github.it.springtest.controller

import org.springframework.context.annotation.Fallback
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class TestController {
    @GetMapping("test")
    fun test(model: Model): String {
        model.addAttribute("data", "샍으")
        return "test"
    }

    @GetMapping("test-mvc")
    fun testMvc(model: Model, @RequestParam("data") data: String): String {
        model.addAttribute("data", data)
        return "test"
    }

    @GetMapping("test-string")
    @ResponseBody // HTTP 프로토콜 바디 부분에 리턴값 그대로 던져주는거
    fun testString(@RequestParam("data") data: String): String {
         return "$data 를 입력?받음?"
    }

    @GetMapping("test-api")
    @ResponseBody // 객체를 제이손으로다가 전달해주는 에피아이
    fun testApi(@RequestParam("name") name: String, @RequestParam("age", required = false) age: Int?): User {
        return User(name, age)
    }

    class User(var name: String, var age: Int?=null) {
    }
}