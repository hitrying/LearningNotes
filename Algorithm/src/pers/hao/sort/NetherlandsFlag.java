package pers.hao.sort;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 * @author hao
 */
public class NetherlandsFlag {
    /**
     * 给定数组nums和数val，把小于val的数放在nums的左边，等于val的数放中间，大于val的数放右边
     * @param nums
     * @param val
     */
    public static void partition(int[] nums, int val) {
        if (nums == null || nums.length < 2) {
            return;
        }

        partition(nums, 0, nums.length - 1, val);
    }

    private static void partition(int[] nums, int l, int r, int val) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (nums[l] < val) {
                swap(nums, ++less, l++);
            } else if (nums[l] > val) {
                swap(nums, --more, l);
            } else {
                l++;
            }
        }
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
        partition(nums, 5);
        System.out.println(Arrays.toString(nums));
    }
}
