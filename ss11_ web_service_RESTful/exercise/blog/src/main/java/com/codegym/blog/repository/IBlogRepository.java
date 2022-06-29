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
public interface IBlogRepository extends JpaRepository<BlogModel, Integer> {
    Page<BlogModel> findAll(Pageable pageable);

    Page<BlogModel> findAllByCategory_Id(int category_id, Pageable pageable);

    Page<BlogModel> findAllByTitleContainsOrContentContains(String title, String content, Pageable pageable);

    Page<BlogModel> findBlogsByTitleContainsOrContentContains(String title, String content, Pageable pageable);

    List<BlogModel> findAllByCategory_Id(int category_id);
}
