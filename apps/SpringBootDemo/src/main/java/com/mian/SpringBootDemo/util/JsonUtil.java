package com.mian.SpringBootDemo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mian.SpringBootDemo.domain.Address;
import com.mian.SpringBootDemo.domain.Department;

public class JsonUtil {
    public static void main(String[] args) throws JsonProcessingException {

        Address address = new Address();
        address.setName("B6");
        Department department = new Department();
        department.setName("Development");

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(address));;
    }
}
