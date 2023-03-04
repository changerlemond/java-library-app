package com.group.libraryapp.dto.user.request;

import lombok.Getter;

@Getter
public class UserCreateRequest {

    private final String name;

    private final Integer age;

    public UserCreateRequest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
