package com.github.mateusjose98.userservice.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserPutRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
