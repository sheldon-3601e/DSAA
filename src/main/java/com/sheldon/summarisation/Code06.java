package com.sheldon.summarisation;

/**
 * @ClassName Code06
 * @Author 26483
 * @Date 2024/1/25 9:55
 * @Version 1.0
 * @Description TODO
 */
public class Code06 {

    public int test(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        for (int i = 0; i <len - 1; i++) {
            int index = i;
            int removeLen = 0;
            while (nums[index] == nums[index + 1]) {
                removeLen++;
                index++;
            }
            if (removeLen > 0) {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + removeLen];
                }
                len = len - removeLen;
            }
        }
        return len;
    }

    /**
     * 快慢指针法
     *
     * 慢指针指向当前唯一元素的位置，快指针用于遍历数组
     *
     *
     * 双指针法通常在解决数组或链表问题时非常有效。下面列举了一些情况下可以考虑使用双指针的方法：
     * 快慢指针： 当需要找到链表中的中间节点、判断链表是否有环、找到环的起始位置等问题时，
     * 常常使用快慢指针的方法。快指针每次移动两步，慢指针每次移动一步。
     *
     * 左右指针： 在数组中，当需要从两端向中间迭代或在两个有序数组中进行合并等情况时，可以使用左右指针。
     * 左指针通常从数组的起始位置开始，右指针从数组的末尾开始，两者逐步向中间移动。
     *
     * 滑动窗口： 在解决子数组或子字符串的问题时，滑动窗口是一个常用的技巧。
     * 通过维护一个窗口，可以在数组或字符串上进行迭代，而不是使用嵌套循环。
     *
     * 两个指针相向移动： 当需要在有序数组中查找两个数使它们的和等于目标值时，可以使用两个指针相向移动的方法。
     * 一个指针从数组的起始位置开始，另一个指针从数组的末尾开始，根据当前两个指针指向的元素之和与目标值的关系来调整指针的位置。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 边界情况处理
        if (nums.length == 1) {
            return 1;
        }

        // 初始化唯一元素的数量为 1（第一个元素）
        int uniqueCount = 1;

        // 从第二个元素开始遍历数组
        for (int i = 1; i < nums.length; i++) {
            // 判断当前元素是否与前一个元素相等
            if (nums[i] != nums[i - 1]) {
                // 如果不相等，说明找到了一个新的唯一元素，将其放到数组前面
                nums[uniqueCount] = nums[i];
                uniqueCount++;
            }
        }

        return uniqueCount;
    }


    public static void main(String[] args) {
        Code06 code06 = new Code06();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int test = code06.removeDuplicates(nums);
        System.out.println(test);
    }
}
