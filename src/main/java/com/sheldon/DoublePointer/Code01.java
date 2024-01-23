package com.sheldon.DoublePointer;

/**
 * @ClassName Code01
 * @Author 26483
 * @Date 2024/1/23 8:46
 * @Version 1.0
 * @Description
 */

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *  *
 *  * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *  *
 *  *  
 *  *
 *  * 示例 1：
 *  *
 *  * 输入：s = ["h","e","l","l","o"]
 *  * 输出：["o","l","l","e","h"]
 *  *
 */
public class Code01 {

    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            s[i] = (char) (s[i] ^ s[j]);
            s[j] = (char) (s[i] ^ s[j]);
            s[i] = (char) (s[i] ^ s[j]);
        }
    }

    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c', 'd', 'e'};
        reverseString(s);
        System.out.println(s);
    }

}
