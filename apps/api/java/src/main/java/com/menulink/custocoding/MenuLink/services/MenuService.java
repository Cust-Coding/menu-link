package com.menulink.custocoding.MenuLink.services;


import com.menulink.custocoding.MenuLink.dtos.MenuCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.MenuResponseDTO;
import com.menulink.custocoding.MenuLink.mappers.MenuMapper;
import com.menulink.custocoding.MenuLink.repositories.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MenuService {


    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    public MenuResponseDTO saveMenu(
            MenuCreateDTO request
    ){
        var menu = menuMapper.toMenuDTO(request);
        var savedMenu = menuRepository.save(menu);
        return menuMapper.toMenuResponse(savedMenu);
    }


    public List<MenuResponseDTO> getAllMenus(){
        return menuRepository.findAll()
                .stream()
                .map(menuMapper::toMenuResponse)
                .collect(Collectors.toList());
    }

    public MenuResponseDTO getMenuById(
            Long id
    ){
        return menuRepository.findById(id)
                .map(menuMapper::toMenuResponse)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Menu not found"
                ));
    }


    public void deleteMenu(
            Long id
    ){
        menuRepository.deleteById(id);
    }

}
