package com.codegym.controller.restcontroller;

import com.codegym.model.QuestionContent;
import com.codegym.service.customer.impl.QuestionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/question")
public class QuestionContentRestController {
    @Autowired
    private QuestionContentService questionContentService;

    @GetMapping("")
    public ResponseEntity<?> listQuestion() {
        return new ResponseEntity<>(questionContentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<QuestionContent> createQuestion(@Valid @RequestBody QuestionContent questionContent) {
        questionContentService.save(questionContent);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/edit/{id}")
    public ResponseEntity<?> editQuestion(@PathVariable Integer id) {
        QuestionContent questionContent = questionContentService.findById(id);
        return new ResponseEntity<>(questionContent, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editQuestion(@RequestBody QuestionContent questionContent) {
        questionContentService.update(questionContent);
        return new ResponseEntity<>(questionContentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> getDeletingQuestion(@PathVariable Integer id) {
        QuestionContent questionContent = questionContentService.findById(id);
        return new ResponseEntity<>(questionContent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Integer id) {
        questionContentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchByName(@PathVariable String name){
        List<QuestionContent> questionContents= questionContentService.searchByName(name);
        return new ResponseEntity<>(questionContents,HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
