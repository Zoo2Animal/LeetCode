import java.util.Arrays;

/**
 * Name: SquareSort
 * Author: lloydfinch
 * Function: 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * Date: 2020-04-17 11:14
 * Modify: lloydfinch 2020-04-17 11:14
 */
public class SquareSort {

    public static void main(String[] args) {
        SquareSort squareSort = new SquareSort();

        int[] arr = new int[]{-7, -3, 2, 3, 11};
        int[] squares = squareSort.sortedSquares2(arr);

        printArr(squares);
    }

    /**
     * 先求平方，再排序
     */
    public int[] sortedSquares(int[] A) {

        int[] arr = A;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }

        //排序(这里使用的是快速排序)
        Arrays.sort(arr);

        return arr;
    }

    /**
     * 负数已经倒序排序，正数已经正序排序，大的肯定在两头，可以使用"向中间收敛法"
     */
    private int[] sortedSquares2(int[] A) {
        int[] arr = new int[A.length];
        //left取左边，right取右边
        int last = arr.length - 1;
        //这里一定要记得left<=right，带上=，如果数组长度为奇数，且中间元素左右相邻元素的绝对值相同，就会漏掉
        for (int left = 0, right = arr.length - 1; left <= right; ) {
            int leftSquare = A[left] * A[left];
            int rightSquare = A[right] * A[right];

            if (leftSquare < rightSquare) {
                arr[last] = rightSquare;
                right--;
            } else {
                arr[last] = leftSquare;
                left++;
            }

            last--;
        }

        return arr;
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
