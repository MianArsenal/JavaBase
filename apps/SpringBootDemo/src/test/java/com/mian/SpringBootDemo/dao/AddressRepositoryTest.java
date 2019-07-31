package com.mian.SpringBootDemo.dao;

import com.mian.SpringBootDemo.domain.Address;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void test() {
        Address address = new Address();
        address.setName("南软");
        this.addressRepository.save(address);
        Assert.assertEquals(1, this.addressRepository.findByName("南软").size());
        this.addressRepository.delete(address);
    }

}