package com.menulink.custocoding.MenuLink.controllers;
import com.menulink.custocoding.MenuLink.dtos.MenuCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.MenuResponseDTO;
import com.menulink.custocoding.MenuLink.services.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/api/menus")
    public MenuResponseDTO creteMenu(
            @RequestBody MenuCreateDTO request
    ){
        return menuService.saveMenu(request);
    }








}
