package com.harry.reactspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harry.reactspring.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>{


}
