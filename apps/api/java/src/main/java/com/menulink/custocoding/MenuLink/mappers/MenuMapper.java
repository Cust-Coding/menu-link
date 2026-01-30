package com.menulink.custocoding.MenuLink.mappers;


import com.menulink.custocoding.MenuLink.dtos.MenuCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.MenuResponseDTO;
import com.menulink.custocoding.MenuLink.models.Menu;
import org.springframework.stereotype.Service;

@Service
public class MenuMapper {

    public Menu toMenuDTO(MenuCreateDTO dto){
        var menu = new Menu();
        menu.setName(dto.name());
        menu.setDescription(dto.description());
        menu.setRestaurant(dto.restaurant());

        return menu;
    }

    public MenuResponseDTO toMenuResponse(Menu dto){
        return new MenuResponseDTO(
                dto.getName(),
                dto.getDescription(),
                dto.getRestaurant()
        );
    }
}
