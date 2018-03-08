package com.unaryops;

public class GFG {

    public static void find(Integer[] integers, int sum) {
        find(integers, sum, 0);
    }

    public static void find(Integer[] integers, int sum, int start) {
        if (start > integers.length) {
            return;
        }

        int total = 0;
        for (int i = start; i < integers.length; i++) {
            total += integers[i];
            if (total == sum) {
                while (i >= start) {
                    System.out.print(integers[i] + " ");
                    i--;
                }
                System.out.println();
                break;
            }
        }

        find(integers, sum, start+ 1);
    }

    public static Integer subArraySum(Integer arr[], int sum)
    {
        int n = arr.length - 1;
        int total = arr[0], start = 0, i;

        // Pick a starting point
        for (i = 1; i <= n; i++)
        {
            // If total exceeds the sum, then remove the starting elements
            while (total > sum && start < i-1)
            {
                total -= arr[start];
                start++;
            }

            // If total becomes equal to sum, then return true
            if (total == sum)
            {
                int p = i-1;
                System.out.println("Sum found between indexes " + start
                        + " and " + p);
                return 1;
            }

            // Add this element to total
            if (i < n)
                total += arr[i];

        }

        System.out.println("No subarray found");
        return 0;
    }
}
