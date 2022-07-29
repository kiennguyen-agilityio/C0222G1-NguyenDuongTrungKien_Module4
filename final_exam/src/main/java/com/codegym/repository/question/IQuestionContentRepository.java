package com.codegym.repository.question;

import com.codegym.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IQuestionContentRepository extends JpaRepository<QuestionContent,Integer> {
    Page<QuestionContent> findAll(Pageable pageable);
    Page<QuestionContent> findAllByIdContainsOrNameContains(String id, String name, Pageable pageable);

    @Query(value = "SELECT *  FROM question_content WHERE name LIKE :name ", nativeQuery = true)
    List<QuestionContent> searchByName(@Param("name") String name);
}
