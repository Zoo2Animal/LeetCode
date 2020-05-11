/**
 * Name: SortColors
 * Author: lloydfinch
 * Function:
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2020-04-26 14:54
 * Modify: lloydfinch 2020-04-26 14:54
 */
public class SortColors {

    public static void main(String[] args) {

        SortColors sortColors = new SortColors();
        int[] nums = {2, 1, 2, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 2};
        sortColors.sortColors(nums);

        printlnArr(nums);
    }

    /**
     * 思路，统计 0 1 2 出现的次数，然后重新填写数组元素
     *
     * @param nums
     */
    public void sortColors(int[] nums) {

        int zeros = 0;
        int ones = 0;
        int twos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else if (nums[i] == 1) {
                ones++;
            } else if (nums[i] == 2) {
                twos++;
            }
        }
        for (int i = 0; i < zeros; i++) {
            nums[i] = 0;
        }

        for (int i = zeros; i < zeros + ones; i++) {
            nums[i] = 1;
        }

        for (int i = zeros + ones; i < nums.length; i++) {
            nums[i] = 2;
        }
    }


    private static void printlnArr(int[] datas) {
        for (int data : datas) {
            System.out.print(data + " ");
        }
    }
}
