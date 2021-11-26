package pers.hao.draft;

import java.util.Arrays;

/**
 * @author hao
 */
public class InsertionSort1122 {
    public static void insertion(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j - 1 >= 0 && nums[j - 1] > nums[j]; j--) {
                swap(nums, j - 1, j);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static int[] generateArray(int maxValue, int maxSize) {
        int[] nums = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = generateArray(20, 20);
        insertion(nums);
        System.out.println(Arrays.toString(nums));
    }
}
