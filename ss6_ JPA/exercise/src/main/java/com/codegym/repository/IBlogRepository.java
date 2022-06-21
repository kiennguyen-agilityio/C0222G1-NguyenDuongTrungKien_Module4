package com.codegym.repository;
import com.codegym.model.BlogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<BlogModel, Integer> {
    @Query(value = "select * from blog", nativeQuery = true)
    List<BlogModel> findAll();

    @Query(value = "insert into blog (id,title,content) value (:id,:title,:content )", nativeQuery = true)
    BlogModel save(@Param("id") int id, @Param("title") String title, @Param("content") String content);

    @Modifying
    @Query(value = "update blog set title=:title,content=:content where id=:id", nativeQuery = true)
    int update(@Param("title") String title, @Param("content") String content, @Param("id") Integer id); //int :kieu du lieu cua update phai tra ve void

    @Query(value = "select * from blog where id=:id", nativeQuery = true)
    BlogModel findById(@Param("id") int id);

    @Modifying
    @Query(value = "delete from blog where id=:id", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "select * from blog where title like :title", nativeQuery = true)
    List<BlogModel> search(@Param("title") String title);
}
