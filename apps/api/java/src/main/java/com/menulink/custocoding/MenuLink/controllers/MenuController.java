package com.menulink.custocoding.MenuLink.controllers;
import com.menulink.custocoding.MenuLink.dtos.MenuCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.MenuResponseDTO;
import com.menulink.custocoding.MenuLink.services.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MenuController {

    private final MenuService menuService;


    @GetMapping("/api/menu")
    public List<MenuResponseDTO> getMenus(){

        return menuService.getAllMenus();
    }

    @GetMapping("/api/menu/{id}")
    public MenuResponseDTO getMenuById(
            @PathVariable("id") Long id
    ){
        return menuService.getMenuById(id);
    }

    @PostMapping("/api/menu")
    public MenuResponseDTO createMenu(
            @RequestBody MenuCreateDTO request
    ){
        return menuService.saveMenu(request);
    }

    @DeleteMapping("/api/menu/{id}")
    public void deleteMenu(
            @PathVariable("id") Long id
    ){
        menuService.deleteMenu(id);

    }









}
