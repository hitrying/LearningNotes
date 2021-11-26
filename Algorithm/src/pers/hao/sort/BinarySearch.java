package pers.hao.sort;

/**
 * 二分查找
 * @author hao
 */
public class BinarySearch {
    /**
     * 迭代终止条件 l <= r
     * @param sortArr 有序数组
     * @param num
     * @return
     */
    public static boolean exist(int[] sortArr, int num) {
        if (sortArr == null || sortArr.length == 0) {
            return false;
        }

        int l = 0;
        int r = sortArr.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (sortArr[m] == num) {
                return true;
            } else if (sortArr[m] > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return false;
    }

    /**
     * 迭代终止条件 l < r
     * 执行到"sortArr[l] == num"时l == r
     * @param sortArr
     * @param num
     * @return
     */
    public static boolean existEqual(int[] sortArr, int num) {
        if (sortArr == null || sortArr.length == 0) {
            return false;
        }

        int l = 0;
        int r = sortArr.length - 1;
        int m = 0;
        while (l < r) {
            m = l + ((r - l) >> 1);
            if (sortArr[m] == num) {
                return true;
            } else if (sortArr[m] > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return sortArr[l] == num;
    }

    public static void main(String[] args) {
        int[] sortArr = {1, 2, 4, 5, 7, 8, 9};
        System.out.println(exist(sortArr, 5));
    }
}
