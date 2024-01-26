package com.sheldon.basic.ArraysAndStrings.DoublePointer;

import java.util.Arrays;

/**
 * @ClassName Code02
 * @Author 26483
 * @Date 2024/1/23 8:52
 * @Version 1.0
 * @Description TODO
 */

/**
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 *
 * 返回该 最大总和 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,4,3,2]
 * 输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 所以最大总和为 4
 *
 */
public class Code02 {

    // 计数排序
    public static int[] countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr; // 数组为空或只有一个元素时已经有序
        }

        // 寻找最小值和最大值
        int minVal = Arrays.stream(arr).min().getAsInt();
        int maxVal = Arrays.stream(arr).max().getAsInt();

        // 计算范围
        int rangeSize = maxVal - minVal + 1;

        // 初始化计数数组和结果数组
        int[] countArray = new int[rangeSize];
        int[] resultArray = new int[arr.length];

        // 统计频次
        for (int num : arr) {
            countArray[num - minVal]++;
        }

        // 计算累积频次
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        // 排序
        for (int i = arr.length - 1; i >= 0; i--) {
            resultArray[countArray[arr[i] - minVal] - 1] = arr[i];
            countArray[arr[i] - minVal]--;
        }

        return resultArray;
    }

    public static int test(int[] nums) {
        nums = countingSort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {6,2,6,5,1,2};
        int test = test(nums);
        System.out.println(test);
    }

}
