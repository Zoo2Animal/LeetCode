import java.util.HashMap;

/**
 * Name: GuessWorld
 * Author: lloydfinch
 * Function:
 * 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
 * <p>
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 * <p>
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: secret = "1807", guess = "7810"
 * <p>
 * 输出: "1A3B"
 * <p>
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 * 示例 2:
 * <p>
 * 输入: secret = "1123", guess = "0111"
 * <p>
 * 输出: "1A1B"
 * <p>
 * 解释: 朋友猜测数中的第一个 1 是公牛，第二个或第三个 1 可被视为奶牛。
 * 说明: 你可以假设秘密数字和朋友的猜测数都只包含数字，并且它们的长度永远相等。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bulls-and-cows
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2020-04-20 13:57
 * Modify: lloydfinch 2020-04-20 13:57
 */
public class GuessWorld {


    public static void main(String[] args) {
        GuessWorld guessWorld = new GuessWorld();


        String secret = "18";
        String guess = "78";

        String hint = guessWorld.getHint(secret, guess);
        System.out.println(hint);
    }

    /*
        Time complexity: O(n)
        Space complexity: O(1)
     */
    public String getHint(String secret, String guess) {
        int aCount = 0;     // 公牛数
        int bCount = 0;     // 母牛数
        //int mapS[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        //int mapG[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] mapS = new int[10];
        int[] mapG = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char temp = secret.charAt(i);
            if (temp == guess.charAt(i))
                aCount++;
            else {
                mapS[temp - '0']++;
                mapG[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            bCount += Math.min(mapG[i], mapS[i]);
        }
        return aCount + "A" + bCount + "B";
    }

    /**
     * Splendid
     *
     * @param secret 实际world
     * @param guess  猜测的world
     * @return
     */
    public String getHint2(String secret, String guess) {
        //数字只能是0-1，用一个length1=0的数组就ok，下标表示数字，值表示没猜中的次数
        int[] bucket = new int[10];
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
                continue;
            }

            //假设没猜中，这个数字的次数+1
            bucket[secret.charAt(i) - '0'] += 1;
            //假设猜中，这个数字的次数-1
            bucket[guess.charAt(i) - '0'] -= 1;

        }
        //计算bucket中正值的个数，就是没猜中的个数
        for (int i = 0; i < 10; i++) {
            if (bucket[i] > 0)
                cow += bucket[i];
        }

        //length-bull就是没猜对的个数，减去没猜中的个数就是猜中的个数
        cow = secret.length() - bull - cow;
        String res = bull + "A" + cow + "B";
        return res;
    }
}
