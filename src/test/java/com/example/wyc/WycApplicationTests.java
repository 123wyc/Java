package com.example.wyc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SpringBootTest
class WycApplicationTests {

    @Test
    void contextLoads() {


        Map<Integer, Integer> test = new HashMap<Integer, Integer>();
        test.put(1, 2);
        test.put(1, 1);

        for (Integer key : test.keySet()
        ) {

            System.out.println(test.get(key));
        }
        Set<Integer> set = new HashSet<Integer>();

        set.add(1);
        set.add(1);

        for (Integer value : set
        ) {
            System.out.println(value);
        }
    }

}
