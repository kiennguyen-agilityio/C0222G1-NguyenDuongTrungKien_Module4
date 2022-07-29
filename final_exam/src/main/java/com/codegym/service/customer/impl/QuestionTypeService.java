package com.codegym.service.customer.impl;

import com.codegym.model.QuestionType;
import com.codegym.repository.question.IQuestionTypeRepository;
import com.codegym.service.customer.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    private IQuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }
}
