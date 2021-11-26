package pers.hao.sort;

import sun.awt.X11.XSetWindowAttributes;

import java.util.Arrays;

/**
 * @author hao
 */
public class BubbleSort {
    public static void bubble(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        /**
         * i <= [nums.length - 1, 1]
         * j => [0, i]
         * 在第i次循环中选出最大的值移到数组最后，再数组size--即[0, size - 1)
         */
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
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
        bubble(nums);
        System.out.println(Arrays.toString(nums));
    }
}
