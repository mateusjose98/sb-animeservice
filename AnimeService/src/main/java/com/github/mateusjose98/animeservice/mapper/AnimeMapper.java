package com.github.mateusjose98.animeservice.mapper;

import com.github.mateusjose98.animeservice.domain.Anime;
import com.github.mateusjose98.animeservice.request.AnimePostRequest;
import com.github.mateusjose98.animeservice.request.AnimePutRequest;
import com.github.mateusjose98.animeservice.response.AnimeGetResponse;
import com.github.mateusjose98.animeservice.response.AnimePostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnimeMapper {
    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(100_000))")
    Anime toAnime(AnimePostRequest postRequest);

    Anime toAnime(AnimePutRequest request);

    AnimePostResponse toAnimePostResponse(Anime anime);

    AnimeGetResponse toAnimeGetResponse(Anime anime);

    List<AnimeGetResponse> toAnimeGetResponseList(List<Anime> animes);

}