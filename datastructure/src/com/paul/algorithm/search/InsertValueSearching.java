package com.paul.algorithm.search;

/**
 * @Desc: 插值查找算法
 * @Date: 2022-05-26 22:02
 * @Author: paul
 */
public class InsertValueSearching {

    public static void main(String[] args) {

        //		int [] arr = new int[100];
//		for(int i = 0; i < 100; i++) {
//			arr[i] = i + 1;
//		}

        int[] arr = { 1, 8, 10, 89,1000,1000, 1234 };

        int index = insertValueSearch(arr, 0, arr.length - 1, 1234);
        //int index = binarySearch(arr, 0, arr.length, 1);
        System.out.println("index = " + index);

        //System.out.println(Arrays.toString(arr));

    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        System.out.println("二分查找被调用~");
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // 向 右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {

            return mid;
        }

    }

    /**
     * 返回要查找值的索引位置
     * @param arr 给定【有序】数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 查找值
     * @return 索引位置,如果没有找到则返回 -1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        System.out.println("=====被调用=====");

        // 递归的终止条件，必须有！
        // 否则 mid 可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return  -1;
        }

        // 求mid值
        // 该公式为插值查找算法特有的求mid公式
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 如果比中间值大，应该向右递归(适合：数组中的值，从小到大)
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else  if (findVal < midVal) { // 如果比中间值小，应该想左递归
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }

}
