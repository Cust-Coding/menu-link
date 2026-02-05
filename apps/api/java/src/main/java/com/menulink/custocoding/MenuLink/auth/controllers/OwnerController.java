package com.menulink.custocoding.MenuLink.auth.controllers;


import com.menulink.custocoding.MenuLink.auth.dtos.OwnerCreateDTO;
import com.menulink.custocoding.MenuLink.auth.dtos.OwnerResponseDTO;
import com.menulink.custocoding.MenuLink.auth.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping("/api/owner")
    public List<OwnerResponseDTO> getAllOwners(){
        return ownerService.getAllOwners();
    }

    @GetMapping("/api/owner/{id}")
    public OwnerResponseDTO getOwnerById(
            @PathVariable("id") Long id
    ){
        return ownerService.getOwnerById(id);
    }

    @PostMapping("/api/owner")
    public OwnerResponseDTO saveOwner(
            @RequestBody OwnerCreateDTO owner
    ){
       return ownerService.saveOwner(owner);
    }





}
