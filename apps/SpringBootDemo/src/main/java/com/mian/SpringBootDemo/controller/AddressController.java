package com.mian.SpringBootDemo.controller;

import com.mian.SpringBootDemo.domain.Address;
import com.mian.SpringBootDemo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private static final String SUCCESS = "SUCCESS";
    @Autowired
    private AddressService addressService;

    @RequestMapping("/insert")
    public Address insert(@RequestBody Address address) {
        return this.addressService.insertAddress(address);
    }

    @RequestMapping("/delete/{name}")
    public String deleteByName(@PathVariable String name) {
        this.addressService.deleteAddressByName(name);
        return SUCCESS;
    }

    @RequestMapping("/name/{name}")
    public List<Address> findByName(@PathVariable String name) {
        return this.addressService.findAddressByName(name);
    }
}


