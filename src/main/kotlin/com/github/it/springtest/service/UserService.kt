package com.github.it.springtest.service

import com.github.it.springtest.domain.User
import com.github.it.springtest.repository.MemoryUserRepository
import com.github.it.springtest.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    /**
     * 얘는 약간 메서드명을 복잡? 상세하게 짓고, (실제 서비스 로직)
     * 조금더 단차원 적인 UserRepository 는 가능한 원시적인 메서드 명으로
     */

    fun join(user: User) {
        // 커맨드 옵션 V!!!!!
        checkUserNameDuplicate(user)

        userRepository.save(user)
        return
    }

    fun findUsers(): List<User> {
        return userRepository.findAll()
    }

    fun findOne(userId: Long): User? {
        return userRepository.findById(userId)
    }

    private fun checkUserNameDuplicate(user: User) {
        userRepository.findByName(user.name!!).let {
            throw IllegalStateException("해당 이름을 가진 사용자가 이미 있습니다")
        }
    }
}