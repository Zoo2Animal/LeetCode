import java.util.Arrays;
import java.util.HashMap;

/**
 * Name: Intersect
 * Author: lloydfinch
 * Function:
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2020-04-22 10:30
 * Modify: lloydfinch 2020-04-22 10:30
 */
public class Intersect {

    public static void main(String[] args) {

        Intersect intersect = new Intersect();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] result = intersect.intersect(nums1, nums2);

        printlnArr(result);
    }

    /**
     * 求交集
     *
     * @param nums1 较大数组
     * @param nums2 较小数组
     * @return 交集(含重复元素)
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        //假设nums1是较大数组
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        //将nums1的元素存放在map中，key是元素值，value是出现的次数
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        //存储相同的元素个数
        int same = 0;
        //在map中找nums2的值
        for (int i : nums2) {
            int count = map.getOrDefault(i, 0);
            if (count > 0) {
                //将交集保存到nums1
                nums1[same] = i;
                //更新下标
                same++;
                //比较过一次，就将次数减1
                map.put(i, count - 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, same);
    }

    private static void printlnArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
