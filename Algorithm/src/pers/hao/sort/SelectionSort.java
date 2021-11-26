package pers.hao.sort;

import java.util.Arrays;

/**
 * @author hao
 */
public class SelectionSort {
    public static void selection(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        /**
         * i => [0, nums.length - 1)
         * j => [i + 1, nums.length)
         * 在第i次循环中找到最小值的索引，与第i个数相交换，数组长度size--即[i, size - 1)，i在不断增大
         */
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                minIndex = nums[j] < nums[minIndex] ? j : minIndex;
            }
            swap(nums, i, minIndex);
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
        int[] nums = generateArray(20, 10);
        selection(nums);
        System.out.println(Arrays.toString(nums));
    }
}
