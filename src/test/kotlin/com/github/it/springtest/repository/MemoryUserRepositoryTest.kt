package com.github.it.springtest.repository

import com.github.it.springtest.domain.User
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class MemoryUserRepositoryTest {

    val repository = MemoryUserRepository()

    @AfterEach
    fun afterEach() {
        // 매 메서드의 테스트가 끝날때마다 실행되는 후처리 매서드.
        // 각 메서드의 테스트는 독립적으로 동작해야함!
        // 그래서 각 메서드의 테스트가 끝날때마다 레포를 비워

        // 테스트 관련해서 깊게 공부하는게 중요하단다
        repository.userMap.clear()
    }

    @Test
    fun save() {
        val user = User()
        user.name = "John"

        repository.save(user)

        val result = repository.findById(user.id!!)

        // user 가 result 에 대해 같은가?
        assertThat(user).isEqualTo(result)

    }

    @Test
    fun findByName() {
        val user = User()
        user.name = "asdf"
        repository.save(user)
        val result = repository.findByName("asdf")
        // result 는 user 가 나와야 한다!
        assertThat(result).isEqualTo(user)

        val user1 = User()
        user1.name = "asdf1"
        repository.save(user1)
        val result1 = repository.findByName("asdf1")
        // result 는 user 가 나와야 한다!
        assertThat(result1).isEqualTo(user1)
    }


    @Test
    fun findAll() {
        val user = User()
        repository.save(user)

        val user1 = User()
        repository.save(user1)

        // 유저맵 사이즈는 2 가 나와야 한다!
        assertThat(repository.userMap.size).isEqualTo(2)
    }
}