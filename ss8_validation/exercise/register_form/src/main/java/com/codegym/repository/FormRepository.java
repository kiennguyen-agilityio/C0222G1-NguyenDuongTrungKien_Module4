package com.codegym.repository;

import com.codegym.model.FormModel;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FormRepository extends PagingAndSortingRepository<FormModel,Long> {

}
