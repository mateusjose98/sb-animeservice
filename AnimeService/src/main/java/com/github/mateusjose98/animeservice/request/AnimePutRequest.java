package com.github.mateusjose98.animeservice.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class AnimePutRequest {

    private Long id;
    private String name;
}