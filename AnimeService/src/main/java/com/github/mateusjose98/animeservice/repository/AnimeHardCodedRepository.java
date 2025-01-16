package com.github.mateusjose98.animeservice.repository;

import com.github.mateusjose98.animeservice.domain.Anime;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AnimeHardCodedRepository {

    private final AnimeData animeData;

    public AnimeHardCodedRepository(
            AnimeData animeData) {
        this.animeData = animeData;
    }

    public List<Anime> findAll() {
        return animeData.findAll();
    }

    public Optional<Anime> findById(
            Long id) {
        return animeData.findAll().stream()
                .filter(anime -> anime.getId()
                        .equals(id)).findFirst();
    }

    public List<Anime> findByName(
            String name) {
        return animeData.findAll().stream()
                .filter(anime -> anime.getName()
                        .equalsIgnoreCase(name))
                .toList();
    }

    public Anime save(Anime anime) {
        animeData.findAll().add(anime);
        return anime;
    }

    public void delete(Anime anime) {
        animeData.findAll().remove(anime);
    }

    public void update(Anime anime) {
        delete(anime);
        save(anime);
    }
}
