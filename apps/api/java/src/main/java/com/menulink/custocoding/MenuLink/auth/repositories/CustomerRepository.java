package com.menulink.custocoding.MenuLink.auth.repositories;

import com.menulink.custocoding.MenuLink.auth.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
