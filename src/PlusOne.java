/**
 * Name: PlusOne
 * Author: lloydfinch
 * Function: 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2020-04-14 16:13
 * Modify: lloydfinch 2020-04-14 16:13
 */
public class PlusOne {

    public static void main(String[] args) {

        int[] digits = new int[]{9, 9, 9, 9};
        int[] results = plusOne(digits);
        printArr(results);
    }

    private static int[] plusOne(int[] digits) {

        //从末位开始+1
        for (int i = digits.length - 1; i >= 0; i--) {
            //先+1再对10求余
            digits[i] = (++digits[i]) % 10;
            //如果没有进位，直接返回即可
            if (digits[i] != 0) {
                return digits;
            }
            //如果有进位，继续向前+1
        }

        //如果全部有进位，则必定是999这种类型，直接返回1000这种即可
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
