package com.menulink.custocoding.MenuLink.controllers;


import com.menulink.custocoding.MenuLink.dtos.MenuCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.MenuResponseDTO;
import com.menulink.custocoding.MenuLink.models.Menus;
import com.menulink.custocoding.MenuLink.repositories.MenuRepository;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class MenuController {

    private final MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    @PostMapping("/api/menus")
    public MenuResponseDTO creteMenu(
            @RequestBody MenuCreateDTO request
    ){
        var menu = toMenuDTO(request);
        var savedMenu = menuRepository.save(menu);
        return toMenuResponse(savedMenu);
    }

    private Menus toMenuDTO(MenuCreateDTO dto){
        var menu = new Menus();
        menu.setName(dto.name());
        menu.setDescription(dto.description());
        menu.setRestaurants(dto.restaurants());

        return menu;
    }

    private MenuResponseDTO toMenuResponse(Menus dto){
        return new MenuResponseDTO(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getRestaurants()
        );
    }






}
