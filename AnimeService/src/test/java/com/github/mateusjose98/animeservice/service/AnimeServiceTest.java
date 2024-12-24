package com.github.mateusjose98.animeservice.service;

import com.github.mateusjose98.animeservice.domain.Anime;
import com.github.mateusjose98.animeservice.domain.Producer;
import com.github.mateusjose98.animeservice.exception.CustomNotFoundException;
import com.github.mateusjose98.animeservice.exception.NotFoundException;
import com.github.mateusjose98.animeservice.repository.AnimeHardCodedRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AnimeServiceTest {

    @InjectMocks
    private AnimeService animeService;

    @Mock
    private AnimeHardCodedRepository repository;

    List<Anime> animes;

    @BeforeEach
    void setUp() {
        animes = new ArrayList<>(List.of(
                new Anime(1L, "Naruto" ),
                new Anime(2L, "One Piece" ),
                new Anime(3L, "Dragon Ball" )
        ));
    }

    @Test
    @DisplayName("findAll returns a list with all producers")
    void findAll() {
        BDDMockito.when(repository.findAll()).thenReturn(animes);
        var result = animeService.findAll(null);
        Assertions.assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .hasSameElementsAs(animes);
    }

    @Test
    @DisplayName("findAll returns when search by name")
    void findAllByName() {

        BDDMockito.when(repository.findByName(animes.getFirst().getName())).thenReturn(List.of(animes.get(0)));

        var result = animeService.findAll("Naruto");
        Assertions.assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .contains(animes.get(0));
    }

    @Test
    @DisplayName("findAll returns a empty list when search by name does not exist")
    void findAllByNameNotFound() {
        BDDMockito.when(repository.findByName("Toei Animation")).thenReturn(new ArrayList<>());
        var result = animeService.findAll("Toei Animation");
        Assertions.assertThat(result)
                .isNotNull()
                .isEmpty();
    }

    @Test
    void findByIdOrThrowNotFound() {
        Optional<Anime> expected = Optional.of(animes.get(0));
        BDDMockito.when(repository.findById(1L)).thenReturn(expected);
        var result = animeService.findByIdOrThrowNotFound(1L);
        Assertions.assertThat(result)
                .isNotNull()
                .isEqualTo(expected.get());
    }

    @Test
    @DisplayName("findByIdOrThrowNotFound throws exception when producer not found")
    void findByIdOrThrowNotFoundThrowsException() {
        BDDMockito.when(repository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> animeService.findByIdOrThrowNotFound(1L))
                .isInstanceOf(CustomNotFoundException.class);
    }

    @Test
    void save() {
        var producer = animes.get(0);
        BDDMockito.when(repository.save(producer)).thenReturn(producer);
        var result = animeService.save(producer);
        Assertions.assertThat(result)
                .isNotNull()
                .isEqualTo(producer);
    }

    @Test
    void delete() {
        var producer = animes.get(0);
        BDDMockito.when(repository.findById(1L)).thenReturn(Optional.of(producer));
        animeService.delete(1L);
        Mockito.verify(repository, Mockito.times(1)).delete(producer);
    }

    @Test
    void deleteThrowsException() {
        BDDMockito.when(repository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> animeService.delete(1L))
                .isInstanceOf(CustomNotFoundException.class);
    }
}