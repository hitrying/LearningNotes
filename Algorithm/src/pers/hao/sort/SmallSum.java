package pers.hao.sort;

import java.util.Arrays;

/**
 * @author hao
 */
public class SmallSum {
    public static int mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        return mergeSort(nums, l, m)
                + mergeSort(nums, m + 1, r)
                + merge(nums, l, m, r);
    }

    private static int merge(int[] nums, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            res += nums[p1] < nums[p2] ? (r - p2 + 1) * nums[p1] : 0;
            help[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= m) {
            help[i++] = nums[p1++];
        }
        while (p2 <= r) {
            help[i++] = nums[p2++];
        }
        for (i = 0; i < help.length; i++) {
            nums[l + i] = help[i];
        }

        return res;
    }

    public static int[] generateArray(int maxValue, int maxSize) {
        int[] nums = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = generateArray(20, 20);
        int res = mergeSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(res);
    }
}
