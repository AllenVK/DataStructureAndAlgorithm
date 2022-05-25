package com.paul.algorithm.search;

/**
 * @Desc: 顺序(线性)查找算法
 * @Date: 2022-05-25 22:10
 * @Author: paul
 */
public class SeqSearching {

    public static void main(String[] args) {

        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = seqSearch(arr, 11);
        if (index == -1) {
            System.out.println("未找到");
        } else {
            System.out.println("找到，集合中的下标为：" + index);
        }

    }

    /**
     * 顺序(线性)查找方法
     * 当前是实现：找到一个满足条件的值，就返回（不支持查找多个相同的值）
     * @param arr 给定的无序集合
     * @param value 要查找的值
     */
    public static int seqSearch(int[] arr, int value) {

        // 线性查找是逐一对比，发现有相同的值，就返回集合下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }

        return -1;
    }

}
