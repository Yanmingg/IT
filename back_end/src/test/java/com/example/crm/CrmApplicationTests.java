package com.example.crm;

import com.example.crm.entity.User;
import com.example.crm.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrmApplicationTests {
    @Autowired
    private UserRepository userRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void Save(){
        User user = new User();
        user.setName("AA");
        user.setAddress("BB");
        user.setEmail("VV");
        user.setPassword("CC");
        User user1 = userRepository.save(user);
        System.out.println(user1);
    }

}
