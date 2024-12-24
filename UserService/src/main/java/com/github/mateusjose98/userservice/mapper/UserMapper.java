package com.github.mateusjose98.userservice.mapper;


import com.github.mateusjose98.userservice.domain.User;
import com.github.mateusjose98.userservice.request.UserPostRequest;
import com.github.mateusjose98.userservice.request.UserPutRequest;
import com.github.mateusjose98.userservice.response.UserGetResponse;
import com.github.mateusjose98.userservice.response.UserPostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(100_000))")
    User toUser(UserPostRequest postRequest);

    User toUser(UserPutRequest request);

    UserPostResponse toUserPostResponse(User user);

    UserGetResponse toUserGetResponse(User user);

    List<UserGetResponse> toUserGetResponseList(List<User> users);

}
