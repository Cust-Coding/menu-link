package com.menulink.custocoding.MenuLink.controllers;

import com.menulink.custocoding.MenuLink.dtos.CustomerCreateDTO;
import com.menulink.custocoding.MenuLink.dtos.CustomerResponseDTO;
import com.menulink.custocoding.MenuLink.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/api/customer")
    public List<CustomerResponseDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/api/customer/{id}")
    public CustomerResponseDTO getCustomerById(
            @PathVariable("id") String id

    ){
        return customerService.getCustomerById(id);
    }


    @PostMapping("/api/customer")
    public CustomerResponseDTO saveCustomer(
            @RequestBody CustomerCreateDTO customer
    ){
        return  customerService.saveCustomer(customer);
    }

    @DeleteMapping("/api/customer/{id}")
    public void deleteCustomer(
            @PathVariable("id") String id
    ){
        customerService.deleteCustomer(id);
    }









}
