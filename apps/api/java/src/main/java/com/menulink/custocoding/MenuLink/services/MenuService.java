package com.menulink.custocoding.MenuLink.services;


import com.menulink.custocoding.MenuLink.dtos.MenuCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.MenuResponseDTO;
import com.menulink.custocoding.MenuLink.mappers.MenuMapper;
import com.menulink.custocoding.MenuLink.repositories.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

}
