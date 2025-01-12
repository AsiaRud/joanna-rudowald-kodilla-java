package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Empty List Test: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Empty List Test: end");
    }

    @DisplayName("Given the list is empty, " +
            "then the result list is empty"
    )

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> result = OddNumbersExterminator.exterminate(emptyList);
        Assertions.assertTrue(result.isEmpty());
    }

    @DisplayName("Given the list contains even and odd numbers, " +
            "then the result list contains only even numbers")

    @Test
    public void testOddNumbersExterminatorNormalList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(24);
        list.add(301);
        list.add(14);
        List<Integer> result = OddNumbersExterminator.exterminate(list);
        for(int number:result){
            Assertions.assertTrue(number % 2 == 0);
        }
    }
}
