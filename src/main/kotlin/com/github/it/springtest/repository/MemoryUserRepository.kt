package com.github.it.springtest.repository

import com.github.it.springtest.domain.User

class MemoryUserRepository : UserRepository() {

    val userMap: MutableMap<Long, User> = mutableMapOf()
    var sequence: Long = 0

    fun clear() {
        userMap.clear()
    }

    override fun save(user: User): User {
        user.id = sequence++
        userMap[user.id!!] = user
        return user
    }

    override fun findById(id: Long): User? {
        return userMap[id]
    }

    override fun findByName(name: String): User? {
        // 코틀린 람ㅂ다문법
        return userMap.values.firstOrNull { user: User ->  user.name == name }
    }

    override fun findAll(): List<User> {
        return userMap.values.toList()
    }
}