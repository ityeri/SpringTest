package com.github.it.springtest.repository

import com.github.it.springtest.domain.User
import org.springframework.stereotype.Repository

@Repository
abstract class UserRepository {
    abstract fun save(user: User): User

    abstract fun findById(id: Long): User?
    abstract fun findByName(name: String): User?

    abstract fun findAll(): List<User>
}