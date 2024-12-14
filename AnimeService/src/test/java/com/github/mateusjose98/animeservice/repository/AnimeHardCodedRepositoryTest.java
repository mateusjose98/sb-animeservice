package com.github.mateusjose98.animeservice.repository;

import com.github.mateusjose98.animeservice.domain.Anime;
import com.github.mateusjose98.animeservice.domain.Producer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AnimeHardCodedRepositoryTest {

    @InjectMocks
    private AnimeHardCodedRepository animeHardCodedRepository;

    @Mock
    private AnimeData animeData;

    private List<Anime> animes;

    @BeforeEach
    void setUp() {
        animes = new ArrayList<>(List.of(
                new Anime(1L, "Naruto" ),
                new Anime(2L, "One Piece" ),
                new Anime(3L, "Dragon Ball" )
        ));
        BDDMockito.when(animeData.findAll()).thenReturn(animes);
    }

    @Test
    @DisplayName("findAll returns a list with all animes")
    void findAll() {
        var result = animeHardCodedRepository.findAll();
        Assertions.assertThat(result)
                .isNotNull()
                .isNotEmpty()
                .hasSameElementsAs(animes);
    }

    @Test
    void findById() {
        var expectedAnime = animes.get(0);
        var result = animeHardCodedRepository.findById(1L);
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(expectedAnime.getId(), result.get().getId());
    }


}