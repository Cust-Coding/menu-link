package com.menulink.custocoding.MenuLink.auth.repositories;

import com.menulink.custocoding.MenuLink.auth.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {
}
