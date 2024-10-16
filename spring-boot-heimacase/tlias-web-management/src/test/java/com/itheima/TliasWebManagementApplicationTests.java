package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testUUID() {
        for (int i = 0; i < 10; i++) {
            System.out.println("UUID: " + UUID.randomUUID().toString());
        }
    }

}
