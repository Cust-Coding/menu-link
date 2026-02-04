package com.menulink.custocoding.MenuLink.auth.repositories;

import com.menulink.custocoding.MenuLink.auth.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
