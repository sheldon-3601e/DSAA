package com.sheldon.basic.Queue;

import java.util.*;

/**
 * @ClassName numSquares
 * @Author 26483
 * @Date 2024/2/5 9:20
 * @Version 1.0
 */
public class numSquares {

	public static void main(String[] args) {
		System.out.println(numSquares01(12));
	}

	/**
	 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
	 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
	 * <p>
	 * 思路：
	 * 1.遍历每层的节点
	 * 2.遍历每个节点的根节点，从而判断是否满足条件
	 * 3.如果满足条件，返回层数
	 * 4.如果不满足条件，继续遍历
	 */
	public static int numSquares01(int n) {
		Queue<Integer> queue = new LinkedList<>();
		// 记录使用过的数
		Set<Integer> used = new HashSet<>();
		// 层数
		int step = 0;
		queue.offer(0);
		used.add(0);
		// 遍历每层的节点
		while(!queue.isEmpty()) {
			// 记录每层的节点数
			int size = queue.size();
			step++;
			// 遍历当前层的所有节点
			for (int i = 0; i < size; i++) {
				// 获取当前节点值
				int curVal = queue.poll();
				// 遍历当前节点的可能的子节点，来判断是否满足条件
				// newVal = curVal + j * j
				// 如果 newVal == n，返回层数
				// 如果 newVal > n，则说明，后面的数一定不符合要求，跳出循环
				// 如果 newVal 没有使用过且符合要求，加入队列，并记录使用过
				for (int j = 1; j <= n; j++) {
					int newVal = curVal + j * j;
					if (newVal == n) {
						return step;
					}
					if (newVal > n) {
						break;
					}
					if (!used.contains(newVal)) {
						queue.offer(newVal);
						used.add(newVal);
					}
				}
			}
		}
		return step;
	}


	public static ArrayList<Integer> getList(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=0;i <= n ;i++ ) {
			if (isValid(i)) {
				list.add(i);
			}
		}
		return list;
	}


	public static boolean isValid(int num) {
		for (int i = 0;i < num ;i++ ) {
			if ((i * i) == num) {
				return true;
			}
		}
		return false;
	}



}
