package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.MusicRepo;
import com.codegym.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImp implements MusicService {
    @Autowired
    private MusicRepo musicRepo;


    @Override
    public void save(Music music) {
        musicRepo.save(music);
    }
//
    @Override
    public List<Music> getAll() {
        return musicRepo.getAll();
    }
//
//    @Override
//    public void remove(int idMusic) {
//        musicRepoImp.remove(idMusic);
//    }

    @Override
    public Music findById(int idMusic) {
        return musicRepo.findById(idMusic);
    }

    @Override
    public void update(Music music) {
        musicRepo.update(music.getIdMusic(),music.getNameMusic(),music.getMusician(),music.getTypeOfMusic(),music.getPath());
    }
//
//    @Override
//    public List<Music> search(String nameMusic) {
//        return musicRepoImp.search(nameMusic);
//    }
}
