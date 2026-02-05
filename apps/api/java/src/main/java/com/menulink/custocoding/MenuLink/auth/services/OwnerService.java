package com.menulink.custocoding.MenuLink.auth.services;


import com.menulink.custocoding.MenuLink.auth.dtos.OwnerCreateDTO;
import com.menulink.custocoding.MenuLink.auth.dtos.OwnerResponseDTO;
import com.menulink.custocoding.MenuLink.auth.mappers.OwnerMapper;
import com.menulink.custocoding.MenuLink.auth.repositories.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    public List<OwnerResponseDTO> getAllOwners(){
        return ownerRepository.findAll()
                .stream()
                .map(ownerMapper::toOwnerResponseDTO)
                .collect(Collectors.toList());
    }

    public OwnerResponseDTO getOwnerById(
            Long id
    ){
        return ownerRepository.findById(id)
                .map(ownerMapper::toOwnerResponseDTO)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Owner not found"
                ));
    }

    public OwnerResponseDTO saveOwner(
            OwnerCreateDTO request
    ){
        var owner = ownerMapper.toOwnerDTO(request);
        var savedOwner = ownerRepository.save(owner);
        return ownerMapper.toOwnerResponseDTO(savedOwner);
    }

    public void deleteOwner(
            Long id
    ){
        ownerRepository.deleteById(id);
    }


}
