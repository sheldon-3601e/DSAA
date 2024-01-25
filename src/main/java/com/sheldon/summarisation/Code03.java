package com.sheldon.summarisation;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Code03
 * @Author 26483
 * @Date 2024/1/25 9:08
 * @Version 1.0
 * @Description TODO
 */
public class Code03 {

    /**
     * 采用动态规划的方法，求杨辉三角形的第rowIndex行的数
     *
     * 动态规划的核心思想是利用之前计算过的结果，将问题分解为更小的子问题，并将子问题的解存储起来，以避免重复计算。
     * 在实际应用中，有两种主要的动态规划方法：自顶向下和自底向上。
     *
     * 自顶向下（Top-Down）： 这是一种递归的方法，通过递归地解决问题，
     * 将结果保存在一个数据结构（通常是数组或字典）中，以便在需要时可以立即返回已计算的结果。
     *
     * 自底向上（Bottom-Up）： 这是一种迭代的方法，从最小的子问题开始解决，逐步构建到原始问题。
     * 通常使用迭代循环来填充一个表格或数组，以存储和重复使用子问题的解。
     *
     * 在你的情况下，我们使用了自底向上的方法。在 getRow 方法中，我们通过循环逐行计算杨辉三角的值，每一行的计算都依赖于上一行的值，
     * 但我们在计算过程中使用迭代的方式更新和保存结果。这样做可以避免递归中的重复计算，提高了效率。
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);

        for (int i = 0; i <= rowIndex; i++) {
            // 初始化每个位置的初始元素为1
            result.add(1);

            // 循环更新当前行的中间元素（不包括第一个和最后一个元素）
            for (int j = i - 1; j > 0; j--) {
                // 更新当前元素，将其值设置为前一行相邻两个元素的和
                result.set(j, result.get(j) + result.get(j - 1));
            }
            // 每一行的最后一个元素都是1，因此无需更新它
        }

        return result;
    }

    public static void main(String[] args) {
        Code03 code03 = new Code03();
        List<Integer> row = code03.getRow(4);
        System.out.println(row);
    }

}
