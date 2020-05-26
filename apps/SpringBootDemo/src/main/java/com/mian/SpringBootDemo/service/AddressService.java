package com.mian.SpringBootDemo.service;

import com.mian.SpringBootDemo.domain.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAddressByName(String name);

    List<Address> findAllAddress();

    void deleteAddressByName(String name);

    Address insertAddress(Address address);
}
