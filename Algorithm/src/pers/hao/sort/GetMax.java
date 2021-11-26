package pers.hao.sort;

/**
 * @author hao
 */
public class GetMax {
    /**
     * 用递归的方法找到数组中的最大值
     * @param nums
     * @return
     */
    public static int getMax(int[] nums) {
        return process(nums, 0, nums.length - 1);
    }

    private static int process(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }

        int mid = l + ((r - l) >> 2);
        int leftMax = process(nums, l, mid);
        int rightMax = process(nums, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

}
