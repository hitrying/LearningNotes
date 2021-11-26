package pers.hao.sort;

import java.util.Arrays;

/**
 * @author hao
 */
public class QuickSort {
    public static void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 等概率随机选择一个数作为划分值，然后把数组按荷兰国旗问题分成三部分。左侧<划分值、中间==划分值、右侧>划分值</划分值、中间==划分值、右侧>
     * 再对左侧范围、右侧范围递归执行
     * @param nums
     * @param l
     * @param r
     */
    private static void quickSort(int[] nums, int l, int r) {
        /**
         * l < r而非l <= r
         * l < r最小划分后有两个数，再加以排序；
         * l = r仅有一个数不用再排序
         */
        if (l < r) {
            swap(nums, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(nums, l, r);
            quickSort(nums, l, p[0] - 1);
            quickSort(nums, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] nums, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (nums[l] < nums[r]) {
                swap(nums, ++less, l++);
            } else if (nums[l] > nums[r]) {
                swap(nums, --more, l);
            } else {
                l++;
            }
        }
        swap(nums, more, r);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
