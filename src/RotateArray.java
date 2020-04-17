/**
 * Name: RotateArray
 * Author: lloydfinch
 * Function:给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 说明:
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * https://leetcode-cn.com/problems/rotate-array/
 * Date: 2020-04-15 18:13
 * Modify: lloydfinch 2020-04-15 18:13
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);
        printArr(nums);
    }


    /**
     * 简单粗暴的方法，将元素后移k次即可
     */
    public static void rotate(int[] nums, int k) {
        //循环遍历k次，每次旋转一个元素
        int first;
        for (int i = 0; i < k; i++) {
            //每次旋转一个元素
            first = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = first;
        }

    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
