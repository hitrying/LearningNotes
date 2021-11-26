package pers.hao.draft;

public class BSNearLeft1125 {
    public static int nearLeft(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] >= val) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
