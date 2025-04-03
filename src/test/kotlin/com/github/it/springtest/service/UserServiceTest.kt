package com.github.it.springtest.service

import com.github.it.springtest.domain.User
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.fail
import kotlin.test.fail


class UserServiceTest {

    val userService = UserService()

    @Test
    fun getUserRepository() {}

    @Test
    fun login() {
        // 겁나 놀라운 사실????
        // 테스트 메서드는 한글로 작성해도 된다??? 예ㅖㅔㅔㅔ??????/////ㅇ/ㅇ//

        // 테스트는 크게 3가지 영역으로 ㅏ뉨
        // 보통 주석을 통해 코드를 given, when, then 으로 나눔

        // given - 텥트용 댙타 생성
        val user = User()
        user.name = "asdf"

        // when - 실제로 뭔갈 하는부분
        userService.join(user)

        // then - 검증부
        Assertions.assertThat(
            userService.findOne(user.id!!)!!.name
        ).isEqualTo(user.name)
    }

    @Test
    fun checkDuplicatedUserName() {
        // given
        val user1 = User()
        user1.name = "asdf"

        val user2 = User()
        user2.name = "asdf"

        // when
        userService.join(user1)

        // then
        // 이 함수가 IllegalStateException 를 던질걸로 예?상됨
//        userService.join(use r2)
        assertThrows<IllegalStateException> {
            userService.join(user2)
        }
    }

    @Test
    fun findUsers() {}
}