package pers.hao.sort;

import java.util.Arrays;

/**
 * @author hao
 */
public class HeapSort {
    public static void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        /**
         * 先把整个数组变成大根堆结构
         */
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, i);
        }
        int size = nums.length;

        /**
         * 把堆的最大值和堆末尾的值进行交换，然后减少堆的大小
         */
        swap(nums, 0, --size);
        while (size > 0) {
            heapify(nums, 0, size);
            swap(nums, 0, --size);
        }
    }

    /**
     * 某个数现在处于index位置，看是否能往上移动(保证大根堆)
     * @param nums
     * @param index
     */
    public static void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 某个数处在index位置，能是否往下移动(交换头尾元素后，继续移动元素保持大根堆)
     * @param nums
     * @param index
     * @param size
     */
    public static void heapify(int[] nums, int index, int size) {
        int left = 2 * index + 1;
        while (left < size) {
            int largest = left + 1 < size && nums[left + 1] > nums[left] ? left + 1: left;
            largest = nums[index] > nums[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(nums, largest, index);
            index = largest;
            left = 2 * index + 1;
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
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
