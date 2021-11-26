package pers.hao.draft;

/**
 * @author hao
 */
public class BSNearLeft1123 {
    public static int nearestLeft(int[] nums, int val) {
        int l = 0, m = 0, r = nums.length - 1, index = -1;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (nums[m] >= val) {
                index = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return index;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 8, 10, 11, 12};
        int val = 6;
        System.out.println(nearestLeft(nums, val));
    }
}
