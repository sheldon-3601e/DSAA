package com.sheldon.basic.set_;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序
 *<p>
 *  
 * <p>
 * 示例 1
 *<p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *<p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *<p>
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/all-about-lockup-table/f84ft/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class intersection {
    public int[] intersection01(int[] nums1, int[] nums2) {
        // 判断边界条件
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }
        // 存储结果的集合
        HashSet<Integer> res = new HashSet<>();
        // 将nums1数组转换为集合
        List<Integer> list = new ArrayList<>();
        for (int item : nums1) {
            list.add(item);
        }
        // 遍历nums2数组，判断是否在集合中
        for (int item : nums2) {
            if (list.contains(item)) {
                res.add(item);
            }
        }
        // 将交集集合转换为数组
        int[] result = new int[res.size()];
        int index = 0;
        for (int num : res) {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        intersection inter = new intersection();
        int[] res = inter.intersection01(nums1, nums2);
        for (int item : res) {
            System.out.println(item);
        }
    }
}