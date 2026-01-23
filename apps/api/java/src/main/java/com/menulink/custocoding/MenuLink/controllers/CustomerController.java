package com.menulink.custocoding.MenuLink.controllers;

import com.menulink.custocoding.MenuLink.dtos.CustomerCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.CustomerResponseDTO;
import com.menulink.custocoding.MenuLink.models.Customers;
import com.menulink.custocoding.MenuLink.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;


@RestController

public class CustomerController {

    public final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }


    @PostMapping("/api/customers")
    public CustomerResponseDTO createCustomer(
            @RequestBody CustomerCreateDTO request
    ){
        var customer = toCustomerDTO(request);
        var savedCustomer = customerRepository.save(customer);
        return toCustomerResponseDTO(savedCustomer);

    }

    private Customers toCustomerDTO(CustomerCreateDTO dto){
        var customer = new Customers();

        customer.setUsername(dto.username());
        customer.setPhonenumber(dto.phonenumber());
        customer.setGender(dto.gender());

        return customer;

    }
    private CustomerResponseDTO toCustomerResponseDTO(Customers dto){
        return new CustomerResponseDTO(
                dto.getId(),
                dto.getUsername(),
                dto.getPhonenumber(),
                dto.getGender()
        );
    }




}
