package com.codegym.service.customer.impl;

import com.codegym.model.QuestionContent;
import com.codegym.repository.question.IQuestionContentRepository;
import com.codegym.service.customer.IQuestionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionContentService implements IQuestionContentService {
    @Autowired
    IQuestionContentRepository iQuestionContentRepository;

    @Override
    public Page<QuestionContent> findAll(Pageable pageable) {
        return iQuestionContentRepository.findAll(pageable);
    }

    @Override
    public List<QuestionContent> findAll() {
        return iQuestionContentRepository.findAll();
    }

    @Override
    public QuestionContent findById(Integer id) {
        return iQuestionContentRepository.findById(id).orElse(null);
    }

    @Override
    public void  save(QuestionContent customer) {
        iQuestionContentRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        iQuestionContentRepository.deleteById(id);
    }
//
//    @Override
//    public Page<QuestionContent> findAllByIdOrName(String search, Pageable pageable) {
//        return iQuestionContentRepository.findAllByIdContainsOrNameContains(search, search, pageable);
//    }
    @Override
    public void update(QuestionContent questionContent) {
        iQuestionContentRepository.save(questionContent);
    }

    @Override
    public List<QuestionContent> searchByTitle(String title) {
        return iQuestionContentRepository.searchByTitle("%"+title+"%");
    }

}
