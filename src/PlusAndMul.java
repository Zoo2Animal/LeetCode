/**
 * Name: PlusAndMul
 * Author: lloydfinch
 * Function: 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * 1 <= n <= 10^5
 * Date: 2020-04-16 10:39
 * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * Modify: lloydfinch 2020-04-16 10:39
 */
public class PlusAndMul {


    public static void main(String[] args) {
        PlusAndMul plusAndMul = new PlusAndMul();

        int n = 99999;
        int result = plusAndMul.subtractProductAndSum(n);

        System.out.println(result);
    }

    public int subtractProductAndSum(int n) {
        //存储乘积
        int mul = 1;
        //存储和
        int sum = 0;
        //存储当前数字
        int num = n;
        //存储当前末位数
        int tail = 0;
        while (num != 0) {
            tail = num % 10;
            sum += tail;
            mul *= tail;
            num /= 10;
        }

        return mul - sum;
    }
}
