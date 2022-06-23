package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface MusicRepo extends PagingAndSortingRepository<Music,Integer> {

    @Query(value = "select * from music", nativeQuery = true)
    List<Music> getAll();


//    @Query(value = "insert into music (id_music,name_music,musician,type_of_music,path_music) value (:id_music,:name_music,:musician,:type_of_music,:path_music)", nativeQuery = true)
//    Music save(@Param("id_music") int id,
//                   @Param("name_music") String nameMusic,
//                   @Param("musician") String musician,
//                   @Param("type_of_music") String typeOfMusic,
//                   @Param("path_music") String path );
//
    @Modifying
    @Query(value = "update music set name_music=:name_music,musician=:musician,type_of_music=:type_of_music,path_music=:path_music where id_music=:id", nativeQuery = true)
    int update(@Param("id") int id,
               @Param("name_music") String nameMusic,
               @Param("musician") String musician,
               @Param("type_of_music") String typeOfMusic,
               @Param("path_music") String path );

    @Query(value = "select * from music where id_music=:id", nativeQuery = true)
    Music findById (@Param("id") int id);
//
//
//    @Modifying
//    @Query(value = "delete from blog where id=:id", nativeQuery = true)
//    void delete(@Param("id") int id);
}
