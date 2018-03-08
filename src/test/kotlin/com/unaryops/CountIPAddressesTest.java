package com.unaryops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountIPAddressesTest {
    @Test
    void ipsBetween() {
        assertEquals(10L, CountIPAddresses.ipsBetween("10.0.0.1", "10.0.0.10"));
        assertEquals(10L, CountIPAddresses.ipsBetween("10.0.0.0", "10.0.255.255"));
    }

}