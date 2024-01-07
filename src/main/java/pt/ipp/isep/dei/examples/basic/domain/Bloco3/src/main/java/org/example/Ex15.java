package org.example;

public class Ex15 {
    public static int[] dividirArrayEmPareseImpares(int[] nums) {
        int[] pares = new int[0];
        int[] impares = new int[0];
        for (int value : nums) {
            if (value <= 0 || value >= 10)
                return pares;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                pares = estenderArrays(pares);
                pares[pares.length - 1] = nums[i];
            }
            if (nums[i] % 2 != 0) {
                impares = estenderArrays(impares);
                impares[impares.length - 1] = nums[i];
            }
        }
        for (int value : pares) {
            impares = estenderArrays(impares);
            impares[impares.length - 1] = value;
        }
        return impares;
    }

    public static int[] estenderArrays(int[] arrays) {
        int[] new_array = new int[arrays.length + 1];
        for (int i = 0; i < arrays.length; i++) {
            new_array[i] = arrays[i];
        }
        return new_array;
    }
}
