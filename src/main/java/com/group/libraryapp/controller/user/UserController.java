package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

//    스프링 빈을 주입 받는 방법
//    1. 생성자 사용 (스프링 버전이 업데이트 되면서 @Autowired 생략 가능)
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    2. setter 사용 (누군가 setter를 사용하면 오작동할 수 있다.)
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

//    3. 필드에 바로 @Autowired 사용: 테스트를 어렵게 만드는 요인
//    @Autowired
//    private final UserService userService;

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }

}
