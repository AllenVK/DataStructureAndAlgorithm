package com.paul.datastructure.sparsearray;

/**
 * @Desc: 稀疏数组
 *
 * @Date: 2022-05-05 22:29
 * @Author: paul
 */
public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组，大小为 11 * 11
        // 0：表示没有棋子；1：表示黑色棋子；2：表示蓝色棋子
        int[][] chessArray1 = new int[11][11];

        // 先默认设定两个棋子，分别是一颗黑子和一颗蓝子
        // 第二行第三列：黑子
        chessArray1[1][2] = 1;
        // 第三行第四列：蓝子
        chessArray1[2][3] = 2;

        // 输出原始二维数组
        System.out.println("原始的二维数组：");
        for (int[] rows : chessArray1) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
