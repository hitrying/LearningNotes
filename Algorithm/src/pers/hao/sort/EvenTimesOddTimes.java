package pers.hao.sort;

/**
 * 0^N == N  N^N == 0
 * @author hao
 */
public class EvenTimesOddTimes {
    /**
     * 一个数组中有一种数出现了奇数次，其他数出现了偶数次，怎么找到这一个数
     * @param nums
     */
    public static void printOddTimesNum1(int[] nums) {
        int eor = 0;
        for (int cur : nums) {
            eor ^= cur;
        }
        System.out.println(eor);
    }

    /**
     * 一个数组中有两种数出现了奇数次，其他数出现了偶数次，怎么找到这两个数
     * @param nums
     */
    public static void printOddTimesNums2(int[] nums) {
        int eor = 0, eorHasOne = 0;
        for (int cur : nums) {
            //数组中2个出现奇数次数字异或的结果
            eor ^= cur;
        }

        //找到最右边的1，也就是从右起两个数字不同的第一个位置
        int rightOne = eor & (~eor + 1);
        for (int cur : nums) {
            //找到与rightOne同位置上皆为1的数相异或
            if ((cur & rightOne) != 0) {
                eorHasOne ^= cur;
            }
        }
        System.out.println(eorHasOne + "  " + (eor ^ eorHasOne));
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 1, 4, 3, 1, 2};
        printOddTimesNums2(nums);
    }
}
