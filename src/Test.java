/**
 * Name: Test
 * Author: lloydfinch
 * Function: 写一些测试代码
 * Date: 2020-04-13 15:10
 * Modify: lloydfinch 2020-04-13 15:10
 */
public class Test {

    public static void main(String[] args) {

        int a = 10;
        int b = 100;

//        a = a - (b += a += b);

//        a = (b ^= a ^= b) ^ a;

        int[] arr = new int[]{b, a};
        a = arr[0];
        b = arr[1];
        System.out.println(a);
        System.out.println(b);

        a = new int[]{b, a}[0];

        System.out.println("a=" + a);
        System.out.println("b=" + b);

    }
}
