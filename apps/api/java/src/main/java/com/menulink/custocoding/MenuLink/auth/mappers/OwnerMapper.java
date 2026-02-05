package com.menulink.custocoding.MenuLink.auth.mappers;


import com.menulink.custocoding.MenuLink.auth.dtos.OwnerCreateDTO;
import com.menulink.custocoding.MenuLink.auth.dtos.OwnerResponseDTO;
import com.menulink.custocoding.MenuLink.auth.models.Owner;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapper {


    public Owner toOwnerDTO(OwnerCreateDTO dto){
        Owner owner = new Owner();
        owner.setFirstname(dto.firstname());
        owner.setLastname(dto.lastname());
        owner.setEmail(dto.email());

        return  owner;
    }

    public OwnerResponseDTO toOwnerResponseDTO(Owner dto){
        return new OwnerResponseDTO(
                dto.getId(),
                dto.getFirstname(),
                dto.getLastname(),
                dto.getEmail()
        );
    }



}
