package com.github.mateusjose98.animeservice.domain;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Anime {

    private Long id;
    private String name;

    public static List<Anime> getAnimes() {
        return List.of(
                new Anime(1L, "Naruto"),
                new Anime(2L, "Dragon Ball"),
                new Anime(3L, "One Piece"));
    }

}
