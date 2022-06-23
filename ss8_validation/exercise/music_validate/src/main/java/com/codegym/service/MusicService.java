package com.codegym.service;

import com.codegym.model.Music;

import java.util.List;

public interface MusicService {

    void save(Music music);

    List<Music> getAll();

//    void remove(int idMusic);
//
    Music findById(int idMusic);
//
    void update(Music music);
//
//    List<Music> search(String nameMusic);
}
