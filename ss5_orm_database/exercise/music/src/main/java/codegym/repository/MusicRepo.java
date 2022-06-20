package codegym.repository;

import codegym.model.Music;

import java.util.List;

public interface MusicRepo {
    List<Music> getAll();

    void save(Music music);

    void remove(int idMusic);

    Music findById(int idMusic);

    void update(Music music);

    List<Music> search(String nameMusic);
}
