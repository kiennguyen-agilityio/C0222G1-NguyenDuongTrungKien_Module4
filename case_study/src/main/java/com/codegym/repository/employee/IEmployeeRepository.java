package com.codegym.repository.employee;

import com.codegym.model.person.customer.Customer;
import com.codegym.model.person.employee.Division;
import com.codegym.model.person.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findByNameContaining(String name, Pageable page);
    @Query(value = "SELECT *  FROM employee WHERE name LIKE :name ", nativeQuery = true)
    List<Employee> searchByName(@Param("name") String name);
}
