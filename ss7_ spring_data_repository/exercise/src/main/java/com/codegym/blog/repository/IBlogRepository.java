package com.codegym.blog.repository;

import com.codegym.blog.model.BlogModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends PagingAndSortingRepository<BlogModel, Integer> {

    @Query(value = "select * from blog", nativeQuery = true)
    List<BlogModel> findAll();

    @Query(value = "select * from blog", nativeQuery = true)
    Page<BlogModel> findAllBlog(Pageable pageable);

    @Query(value = "insert into blog (id,title,content,creat_date,blogcategory_id) value (:id,:title,:content,:create_date,:category_id)", nativeQuery = true)
    BlogModel save(@Param("id") int id, @Param("title") String title,
                   @Param("content") String content,
                   @Param("create_date") String createDate,
                   @Param("category_id") Integer categoryId );

    @Modifying
    @Query(value = "update blog set title=:title,content=:content,create_date=:create_date,category_id=:category_id where id=:id", nativeQuery = true)
    int update(@Param("title") String title,
               @Param("content") String content,
               @Param("create_date") String createDate,
               @Param("category_id")Integer categoryId,
               @Param("id") Integer id);


    @Query(value = "select * from blog where id=:id", nativeQuery = true)
    BlogModel findById(@Param("id") int id);

    @Modifying
    @Query(value = "delete from blog where id=:id", nativeQuery = true)
    void delete(@Param("id") int id);

    Page<BlogModel> findAllByTitleContaining(String keyword, Pageable pageable);

    @Query(value = "select * from blog where title like :title", nativeQuery = true)
    Page<BlogModel> searchByTitle(@Param("title") String title, Pageable pageable);
}
