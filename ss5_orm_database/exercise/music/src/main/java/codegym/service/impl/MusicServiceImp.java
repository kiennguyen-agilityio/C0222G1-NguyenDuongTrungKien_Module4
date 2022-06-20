package codegym.service.impl;

import codegym.model.Music;
import codegym.repository.MusicRepo;
import codegym.repository.impl.MusicRepoImp;
import codegym.service.MusicService;

import java.util.List;

public class MusicServiceImp implements MusicService {
    private MusicRepoImp musicRepoImp = new MusicRepoImp();

    @Override
    public List<Music> getAll() {
        return musicRepoImp.getAll();
    }

    @Override
    public void save(Music music) {
        musicRepoImp.save(music);
    }

    @Override
    public void remove(int idMusic) {
        musicRepoImp.remove(idMusic);
    }

    @Override
    public Music findById(int idMusic) {
        return musicRepoImp.findById(idMusic);
    }

    @Override
    public void update(Music music) {
        musicRepoImp.update(music);
    }

    @Override
    public List<Music> search(String nameMusic) {
        return musicRepoImp.search(nameMusic);
    }
}
