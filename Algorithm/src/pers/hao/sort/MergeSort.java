package pers.hao.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author hao
 */
public class MergeSort {
    public static void mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 将已有的子序列合并，得到完全有序的序列
     * 1）把长度为n的输入序列分成两个长度为in/2的子序列
     * 2）对这两个子序列分别采用归并排序
     * 3）将两个排序好的自序列合并成最终的排序序列
     * @param nums
     * @param l
     * @param r
     */
    private static void mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + ((r - l) >> 1);
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    private static void merge(int[] nums, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
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
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
