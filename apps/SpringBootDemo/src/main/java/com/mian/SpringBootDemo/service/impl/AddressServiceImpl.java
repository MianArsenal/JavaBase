package com.mian.SpringBootDemo.service.impl;

import com.mian.SpringBootDemo.dao.AddressRepository;
import com.mian.SpringBootDemo.domain.Address;
import com.mian.SpringBootDemo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findAddressByName(String name) {
        return this.addressRepository.findByName(name);
    }

    @Override
    public List<Address> findAllAddress() {
        return this.addressRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteAddressByName(String name) {
        this.addressRepository.deleteByName(name);
    }

    @Override
    public Address insertAddress(Address address) {
        return this.addressRepository.save(address);
    }
}
