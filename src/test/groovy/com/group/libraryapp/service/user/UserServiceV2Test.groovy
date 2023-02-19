package com.group.libraryapp.service.user

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.dto.user.request.UserCreateRequest
import com.group.libraryapp.dto.user.request.UserUpdateRequest
import com.group.libraryapp.repository.user.UserRepository
import spock.lang.Specification

class UserServiceV2Test extends Specification {

    UserServiceV2 userServiceV2
    UserRepository userRepository

    def setup() {
        userRepository = Mock()
        userServiceV2 = new UserServiceV2(userRepository)
    }

    def saveUserTest() {
        given:
        def id = null
        UserCreateRequest request = new UserCreateRequest("test", 29)
        userRepository.findByName(request.getName()) >> Optional.empty()

        when:
        userServiceV2.saveUser(request)

        then:
        1 * userRepository.save({
            it.name == request.getName()
            it.age == request.getAge()
            it.id == id
        }) >> { args -> args[0] }
    }

    def updateUserTest() {
        given:
        def id = 1L
        UserUpdateRequest request = new UserUpdateRequest(id, "updateTest")

        and:
        User updateUser = new User("test", 29)
        def field = User.class.getDeclaredField("id")
        field.setAccessible(true)
        field.set(updateUser, id)
        userRepository.findById(id) >> Optional.of(updateUser)

        when:
        userServiceV2.updateUser(request)

        then:
        1 * userRepository.save({
            it.name == request.getName()
            it.id == id
        }) >> { args -> args[0] }
    }

}
