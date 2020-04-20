import java.util.Stack;

/**
 * Name: ReverseLetters
 * Author: lloydfinch
 * Function: 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * <p>
 * 示例 1：
 * <p>
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 * <p>
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 * <p>
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 提示：
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S 中不包含 \ or "
 * Date: 2020-04-20 10:39
 * Modify: lloydfinch 2020-04-20 10:39
 */
public class ReverseLetters {

    public static void main(String[] args) {
        ReverseLetters reverseLetters = new ReverseLetters();
        String s = "a-bC-dEf-ghIj";

        System.out.println(s);

        String result = reverseLetters.reverseOnlyLetters2(s);

        System.out.println(result);
    }

    //判断c是不是字符: a-z A-Z
    private boolean isChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }

        if (c >= 'A' && c <= 'Z') {
            return true;
        }

        return false;
    }


    /**
     * 使用stack,保存所有字符，然后对比原来字符倒序取出即可
     */
    public String reverseOnlyLetters(String S) {
        StringBuilder result = new StringBuilder();
        int length = S.length();
        //全部入栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }
        //对比出栈
        for (int i = 0; i < length; i++) {
            char temp = S.charAt(i);
            if (Character.isLetter(temp)) {
                result.append(stack.pop());
            } else {
                result.append(temp);
            }
        }

        return result.toString();
    }


    /**
     * 使用双指针，倒序找字符
     */
    public String reverseOnlyLetters2(String S) {
        StringBuilder result = new StringBuilder();
        int length = S.length();
        int j = length - 1;
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (Character.isLetter(c)) {
                //这里倒序只取字符，等价于模拟了一个stack
                while (!Character.isLetter(S.charAt(j))) {
                    j--;
                }
                result.append(S.charAt(j--));
            } else {
                result.append(c);
            }

        }


        return result.toString();
    }
}
