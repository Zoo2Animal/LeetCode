/**
 * Name: AddDigits
 * Author: lloydfinch
 * Function:
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 示例:
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2020-04-23 16:40
 * Modify: lloydfinch 2020-04-23 16:40
 */
public class AddDigits {

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        int n = 38;
        int result = addDigits.addDigits(n);
        System.out.println(result);
    }

    public int addDigits(int num) {
        int result = 0;
        int temp = num;

        //将各位数字加起来
        while (temp != 0) {
            result += (temp % 10);
            temp /= 10;
        }

        //检测各位数字长度
        while (result > 9) {
            result = addDigits(result);
        }

        return result;
    }
}
