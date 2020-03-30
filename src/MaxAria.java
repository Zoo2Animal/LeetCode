/**
 * Name: MaxAria
 * Author: lloydfinch
 * Function: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Date: 2020-03-30 10:34
 * Modify: lloydfinch 2020-03-30 10:34
 */
public class MaxAria {

    public static void main(String[] args) {

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = getMaxArea2(height);

        System.out.println("area: " + area);
    }

    /**
     * 暴力求解: 从第一个数开始，依次和后续数字组成容器，类比即可，大的赋值为max，继续对比下一个
     * 时间复杂度O(n^2)
     *
     * @param height 线高
     * @return 面积
     */
    private static int getMaxArea1(int[] height) {
        int maxArea = 0;
        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            }
        }

        return maxArea;
    }

    /**
     * 左右向中间收敛法(夹逼法)
     *
     * @param height
     * @return
     */
    private static int getMaxArea2(int[] height) {
        int maxArea = 0;

        for (int left = 0, right = height.length - 1; left < right; ) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }


        return maxArea;

    }

    /**
     * 计算面积
     *
     * @param height
     * @param left
     * @param right
     * @return
     */
    private static int getArea(int[] height, int left, int right) {
        int area = Math.min(height[left], height[right]) * (right - left);
        return area;
    }
}
