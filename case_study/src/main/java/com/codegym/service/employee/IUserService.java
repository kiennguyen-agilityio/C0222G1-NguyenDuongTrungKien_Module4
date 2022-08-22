package com.codegym.service.employee;

import com.codegym.model.person.employee.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();

    void save(User user);

    Optional<User> findById(Integer id);
}
