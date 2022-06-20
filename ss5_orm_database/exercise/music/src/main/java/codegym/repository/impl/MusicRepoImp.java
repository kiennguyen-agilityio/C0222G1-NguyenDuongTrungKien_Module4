package codegym.repository.impl;

import codegym.model.Music;
import codegym.repository.BaseRepository;
import codegym.repository.MusicRepo;

import javax.persistence.EntityTransaction;
import java.util.List;

public class MusicRepoImp implements MusicRepo {
    @Override
    public List<Music> getAll() {
        List<Music> musicList = BaseRepository.entityManager.createQuery("select m from music m ", Music.class).getResultList();
        return musicList;
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);//persist : them moi
        entityTransaction.commit();
    }

    @Override
    public void remove(int idMusic) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Music music = findById(idMusic);
        BaseRepository.entityManager.remove(music);
        entityTransaction.commit();
    }

    @Override
    public Music findById(int idMusic) {
        Music music = BaseRepository.entityManager.createQuery("select m from music m where idMusic = ?1", Music.class).setParameter(1, idMusic).getSingleResult();
        return music;
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public List<Music> search(String nameMusic) {
        List<Music> music = BaseRepository.entityManager.createQuery("select m from music m where nameMusic like ?1", Music.class).setParameter(1, "%" + nameMusic + "%").getResultList();
        return music;
    }
}
