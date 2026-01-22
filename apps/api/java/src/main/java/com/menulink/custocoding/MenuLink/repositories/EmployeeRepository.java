package com.menulink.custocoding.MenuLink.repositories;

import com.menulink.custocoding.MenuLink.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {
}
