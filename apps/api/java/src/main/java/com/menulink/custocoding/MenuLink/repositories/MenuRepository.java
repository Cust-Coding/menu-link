package com.menulink.custocoding.MenuLink.repositories;

import com.menulink.custocoding.MenuLink.models.Menus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menus,Long> {
}
