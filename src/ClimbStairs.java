/**
 * Name: ClimbStairs
 * Author: lloydfinch
 * Function: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * Date: 2020-03-30 11:06
 * Modify: lloydfinch 2020-03-30 11:06
 */
public class ClimbStairs {

    public static void main(String[] args) {
        int n = 5;
        int methods = climbStairs2(n);
        System.out.println("methods:" + methods);
    }

    /**
     * 暴力求解法:
     * 使用组合的方法
     * (i+1,n) 表示爬一阶，i表示当前阶数，n表示总台阶
     * (i+2,n) 表示爬二阶，i表示当前阶数，n表示总台阶
     *
     * @return
     */
    private static int climbStairs1(int n) {
        return climbStairs1(0, n);
    }

    private static int climbStairs1(int i, int n) {
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        return climbStairs1(i + 1, n) + climbStairs1(i + 2, n);
    }


    /**
     * 路径规划算法:
     * 可以理解为想爬到n，先要爬到n-1，再爬1阶；或者先爬到n-2，再爬2阶，所以d(n) = d(n-1)+d(n-2)
     * ，其中d(1) = 1; d(2) = 2;
     */
    private static int climbStairs2(int n) {
        //用来存储爬法，下标是台阶数，数值是爬法数量，为了方便，ds[0]不用，因为没有0阶

        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int ds[] = new int[n + 1];
        ds[1] = 1;
        ds[2] = 2;
        //从第3阶开始
        for (int i = 3; i <= n; i++) {
            ds[i] = ds[i - 1] + ds[i - 2];
        }

        return ds[n];
    }

    /**
     * 数学归纳法
     * 没有思路 -> 枚举前面几个 -> 找规律 -> 归纳证明
     * 层数
     * 1   1
     * 2   1+1 2
     * 3   1+1+1 1+2 2+1
     * 4   1+1+1+1 1+2+1 2+1+1 1+1+2 2+2
     * 总结归纳:f(1）= 1; f(2) = 2; f(3) = f(1) + f(2); 斐波那契数
     */
    private static int climbStairs3(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int first = 1; //f(1)
        int second = 2; //f(2)

        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}
