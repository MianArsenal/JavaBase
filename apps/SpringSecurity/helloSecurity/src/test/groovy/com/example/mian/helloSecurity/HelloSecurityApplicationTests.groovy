package com.example.mian.helloSecurity

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class HelloSecurityApplicationTests {

    @Autowired
    private MockMvc mockMvc

    @Test
    void accessUnprotected() {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/index")).andExpect(MockMvcResultMatchers.status().isOk())
    }


}
