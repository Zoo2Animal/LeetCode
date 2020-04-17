/**
 * Name: MoveZerosToLast
 * Author: lloydfinch
 * Function: 将一个数组中的所有0元素移动到数组末尾
 * 1 必须在原数组上操作，不能拷贝额外的数组。
 * 2 尽量减少操作次数。
 * https://leetcode-cn.com/problems/move-zeroes/
 * Date: 2020-03-28 20:39
 * Modify: lloydfinch 2020-03-28 20:39
 */
public class MoveZerosToLast {


    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 12};
        arr = new int[]{1};
        moveZero3(arr);
        printArr(arr);
    }


    /**
     * 思路:
     * 1 引入lastIndex=0,然后遍历，凡是不为0的，就arr[lastIndex] = temp,lastIndex++;
     * 这样就可以将所有非0元素保存在左边，lastIndex就是第一个0元素的下标
     * 2 将所有下标 >= lastIndex的全部赋值为0
     * <p>
     * 遍历两次
     */
    private static void moveZero1(int[] nums) {
        int lastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastIndex] = nums[i];
                lastIndex++;
            }
        }

        for (int i = lastIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * TODO 完全掌握了快速排序后再回来写一遍
     * 遍历一次，使用快速排序的思想，pivot是0，将所有不等于0的元素移动到左边
     * leftIndex记录的是下一个不为0的元素的下标，这样会将所有不为0的元素交换到左边，被交换到右边的都是0
     */
    private static void moveZero2(int[] nums) {
        int pivot = 0;
        int leftIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != pivot) {
                int temp = nums[leftIndex];
                nums[leftIndex] = nums[i];
                nums[i] = temp;
                leftIndex++;
            }
        }
    }

    /**
     * 更风骚的写法(有bug)
     *
     * @param nums
     */
    private static void moveZero3(int[] nums) {
        int leftIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[leftIndex] = (nums[i] ^= nums[leftIndex] ^= nums[i]) ^ nums[leftIndex];
                leftIndex++;
            }
        }
    }


    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
