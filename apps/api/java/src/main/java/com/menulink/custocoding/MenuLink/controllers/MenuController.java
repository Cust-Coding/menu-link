package com.menulink.custocoding.MenuLink.controllers;


import com.menulink.custocoding.MenuLink.dtos.MenuCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.MenuResponseDTO;
import com.menulink.custocoding.MenuLink.models.Menu;
import com.menulink.custocoding.MenuLink.repositories.MenuRepository;
import org.springframework.web.bind.annotation.*;

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

    private Menu toMenuDTO(MenuCreateDTO dto){
        var menu = new Menu();
        menu.setName(dto.name());
        menu.setDescription(dto.description());
        menu.setRestaurant(dto.restaurant());

        return menu;
    }

    private MenuResponseDTO toMenuResponse(Menu dto){
        return new MenuResponseDTO(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getRestaurant()
        );
    }






}
