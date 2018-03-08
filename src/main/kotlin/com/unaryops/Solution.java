package com.unaryops;

/*
 * in:  [1, 2, 3]
 * left: [1, 1, 2]
 * right: [6, 3, 1]

 * out: [6, 3, 2]
 */

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        IntProduct intProduct = new IntProduct();

        Integer [] arr = new Integer[] {1, 2, 3};
        Integer [] out = new Integer[arr.length];

//        Arrays.asList(intProduct.product(arr)).forEach(n -> System.out.println(n));
        out = intProduct.product(arr);
        for (int i : out) {
            System.out.println(i);
        }
    }
}

class IntProduct {
    public Integer[] product(Integer[] arr) {
        Integer[] out = new Integer[arr.length];

        int product = 1;
        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];
            System.out.println("Product: " + product);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(product + "/" + arr[i]);
            out[i] = product / arr[i];
            System.out.println(out[i]);
        }

        return out;
    }
}
