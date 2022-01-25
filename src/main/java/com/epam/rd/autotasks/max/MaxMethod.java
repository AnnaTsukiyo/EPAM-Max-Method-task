package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static void main(String[] args) {
        int[] vals = new int[]{-2, 0, 10, 5};
        int result = MaxMethod.max(vals);
        System.out.println(result == 10); // true
    }

    public static int max(int[] values) {
        Integer max = null;
        for (int i = 0; i < values.length; i++) {
            if (max == null) max = values[i];
            if (values[i] > max) {
                max = values[i];
            }
        }
        max = max != null ? max : Integer.MIN_VALUE;
        return max;
    }
}

