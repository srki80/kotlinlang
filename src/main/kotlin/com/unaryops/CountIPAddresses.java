package com.unaryops;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountIPAddresses {

    public static long ipsBetween(String start, String end) {
        List<Long> ip1octets = Stream.of(start.split("\\."))
                .map(chunk -> Long.parseLong(chunk)).collect(toList());

        List<Long> ip2octets = Stream.of(end.split("\\."))
                .map(chunk -> Long.parseLong(chunk)).collect(toList());

        Long ip1 = (ip1octets.get(0) << 24) | (ip1octets.get(1) << 16) | (ip1octets.get(2) << 8) | ip1octets.get(3);
        Long ip2 = (ip2octets.get(0) << 24) | (ip2octets.get(1) << 16) | (ip2octets.get(2) << 8) | ip2octets.get(3);
        return ip2 - ip1;
    }
}
