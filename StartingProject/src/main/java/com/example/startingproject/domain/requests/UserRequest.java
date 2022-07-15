package com.example.startingproject.domain.requests;

import lombok.*;

@Builder
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class UserRequest {
    private String name;
    private String password;
}
