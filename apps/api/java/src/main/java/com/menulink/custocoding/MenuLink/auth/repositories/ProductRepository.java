package com.menulink.custocoding.MenuLink.auth.repositories;

import com.menulink.custocoding.MenuLink.auth.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
