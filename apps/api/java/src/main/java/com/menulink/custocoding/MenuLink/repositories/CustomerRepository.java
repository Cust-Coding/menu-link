package com.menulink.custocoding.MenuLink.repositories;

import com.menulink.custocoding.MenuLink.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers,String> {
}
