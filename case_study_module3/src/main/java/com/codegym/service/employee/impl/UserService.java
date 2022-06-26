package com.codegym.service.employee.impl;

import com.codegym.model.person.employee.User;
import com.codegym.repository.employee.IUserRepository;
import com.codegym.service.employee.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository  ;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
    userRepository.save(user) ;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }
}
