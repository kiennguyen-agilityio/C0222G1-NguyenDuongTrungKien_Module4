package com.codegym.service.customer;

import com.codegym.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestionContentService {
    Page<QuestionContent> findAll(Pageable pageable);

    List<QuestionContent> findAll();

    QuestionContent findById(Integer id);

    void save(QuestionContent customer);

    void delete(Integer id);

    Page<QuestionContent> findAllByIdOrName(String search, Pageable pageable);

    void update(QuestionContent questionContent);

    List<QuestionContent> searchByName(String name);
}
