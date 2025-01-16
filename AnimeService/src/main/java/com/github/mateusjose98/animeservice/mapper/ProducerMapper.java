package com.github.mateusjose98.animeservice.mapper;

import com.github.mateusjose98.animeservice.domain.Producer;
import com.github.mateusjose98.animeservice.request.ProducerPostRequest;
import com.github.mateusjose98.animeservice.request.ProducerPutRequest;
import com.github.mateusjose98.animeservice.response.ProducerGetResponse;
import com.github.mateusjose98.animeservice.response.ProducerPostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProducerMapper {

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "id", expression = "java(java.util.concurrent.ThreadLocalRandom.current().nextLong(100_000))")
    Producer toProducer(
            ProducerPostRequest postRequest);

    Producer toProducer(
            ProducerPutRequest request);

    ProducerGetResponse toProducerGetResponse(
            Producer producer);

    ProducerPostResponse toProducerPostResponse(
            Producer producer);

    List<ProducerGetResponse> toProducerGetResponseList(
            List<Producer> producers);

}