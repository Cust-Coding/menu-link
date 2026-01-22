package com.menulink.custocoding.MenuLink.repositories;

import com.menulink.custocoding.MenuLink.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoy extends JpaRepository<Products,Long> {

}
