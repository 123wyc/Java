package com.example.wyc;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class JavaUtilCollectionsTest {


    @Test
    void testBinarySearch() {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 4, 4, 5, 6, 8));
        Collections.sort(numbers); // 确保列表已排序
        System.out.println(Collections.binarySearch(numbers, 4)); // 输出：2，因为4在索引2处首次出现
        System.out.println(Collections.binarySearch(numbers, 3));
    }

}
