package com.unaryops;

import com.unaryops.maps.HHHMap;
import com.unaryops.maps.HHMap;
import com.unaryops.maps.HMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HMapTest {
    HHHMap<String, Integer> map;
    @BeforeEach
    void setUp() {
        map = new HHHMap<>();
    }

    @Test
    void put() {
        map.put("key1", 1);
        assertEquals(new Integer(1), map.get("key1"));
        map.put("key1", 2);
        assertEquals(new Integer(2), map.get("key1"));
        map.put("key2", 2);
        assertEquals(new Integer(2), map.get("key2"));
        map.put("key3", 2);
        assertEquals(new Integer(2), map.get("key3"));
        assertEquals((int) map.get("key1"), 2);

//        assertTrue(map.size() == 3);
//        assertFalse(map.size() == 5);
//        assertTrue(map.keyExist("key1"));
//        assertTrue(map.keyExist("key3"));
//        assertFalse(map.keyExist("key4"));
    }

    @Test
    void get() {
        assertEquals((int) map.get("key1"), 1);
        map.put("1", 1);


    }

}