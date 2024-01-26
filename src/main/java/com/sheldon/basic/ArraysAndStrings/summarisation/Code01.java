package com.sheldon.basic.ArraysAndStrings.summarisation;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Code01
 * @Author 26483
 * @Date 2024/1/25 8:17
 * @Version 1.0
 * @Description TODO
 */
public class Code01 {

    /**
     * 生成杨辉三角形
     *
     * @param numRows
     * @return
     */
    //
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                }
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
