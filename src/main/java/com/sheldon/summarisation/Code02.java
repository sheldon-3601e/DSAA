package com.sheldon.summarisation;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Code02
 * @Author 26483
 * @Date 2024/1/25 9:01
 * @Version 1.0
 * @Description TODO
 */
public class Code02 {

    /**
     * 采用递归的方法，求杨辉三角形的第rowIndex行的数
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            result.add(getIndexOf(rowIndex, i));
        }
        return result;
    }

    public static int getIndexOf(int rowIndex, int columnIndex) {
        if (rowIndex == 0 || columnIndex == 0 || rowIndex == columnIndex) {
            return 1;
        }
        return getIndexOf(rowIndex - 1, columnIndex - 1) + getIndexOf(rowIndex - 1, columnIndex);
    }
}
