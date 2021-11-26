package pers.hao.sort;

/**
 * @author hao
 */
public class BSNearLeft {
    /**
     * 在有序数组nums中，找到大于等于某个数最左侧的位置
     * 情况1）val小于所有的数[0]：r一直减小，l=0不变，直至r=-1<l
     * 情况2) val大于所有的数[nums.length]：l一直增加，r=nums.length-1不变，直至l=nums.length>r
     * @param nums
     * @param val
     * @return
     */
    public static int nearestIndex(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;
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

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 8, 10, 11, 12};
        int val = 16;
        System.out.println(nearestIndex(nums, val));
    }
}
