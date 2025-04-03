package com.github.it.springtest.controller

import com.github.it.springtest.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class UserController(val userService: UserService) {

}