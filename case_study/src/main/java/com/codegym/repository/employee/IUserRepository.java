package com.codegym.repository.employee;

import com.codegym.model.person.employee.Division;
import com.codegym.model.person.employee.Position;
import com.codegym.model.person.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {
}
