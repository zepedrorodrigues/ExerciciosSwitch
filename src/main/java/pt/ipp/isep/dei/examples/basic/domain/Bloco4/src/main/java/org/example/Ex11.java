package org.example;

public class Ex11 {
    public static int[] multiplosdeNumerosNumArrayNumIntervalo(int min, int max, int[] nums) {
        int[] multiplos_comuns = new int[0];
        int[] invalid = {-1};
        for (int value : nums)
            if (value == 0) {
                return invalid;
            }
        if (nums.length == 0)
            return invalid;
        for (int i = min; i <= max; i++)
            for (int value : nums) {
                if (i % value != 0)
                    break;
                if (value == nums[nums.length - 1]) {
                    multiplos_comuns = Ex4.estenderArray(multiplos_comuns);
                    multiplos_comuns[multiplos_comuns.length - 1] = i;
                }
            }
        return multiplos_comuns;
    }
}
