package com.paul.datastructure.sparsearray;

/**
 * @Desc: 稀疏数组
 * <p>
 *     将二维数组【转换】为稀疏数组的整体思想：
 *      1、先遍历二维数组，得到这个二维数组内非零的总个数
 *      2、创建对应的稀疏数组
 *          a. 先将稀疏数组的第一行的三个元素存储起来：row->行数；col->列数；sum->非零总数
 *          b. 遍历二维数组，将非 0 的值存入 稀疏数组中
 *      3、[实际操作中]：将得到的稀疏数组写入到磁盘文件中，以及从磁盘文件中读取到稀疏数组
 *     eg:
 *      得到稀疏数组为--->
 *      11	11	2
 *      1	2	1
 *      2	3	2
 * </p>
 * <p>
 *     将稀疏数组【还原】为原始的二维数组
 *      1、先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArray1 = int [11][11]
 *      2、在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
 * </p>
 * @Date: 2022-05-05 22:29
 * @Author: paul
 */
public class SparseArray {

    public static void main(String[] args) {

        // 创建一个原始的二维数组，大小为 11 * 11，用于后面的稀疏数组创建
        // 0：表示没有棋子；1：表示黑色棋子；2：表示蓝色棋子
        int[][] chessArray1 = new int[11][11];

        // 先默认设定两个棋子，分别是一颗黑子和一颗蓝子
        // 第二行第三列：黑子
        chessArray1[1][2] = 1;
        // 第三行第四列：蓝子
        chessArray1[2][3] = 2;
        // ...
        chessArray1[4][5] = 2;

        // 输出原始二维数组
        System.out.println("原始的二维数组：");
        for (int[] rows : chessArray1) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 将二维数组转换为稀疏数组
        // 1. 先遍历二维数组，获取非 0 数据的总数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2. 创建稀疏数组：总共只有3列，行数需要根据原始数组中的非 0 总个数定(sum + 1)
        int[][] sparseArr = new int[sum + 1][3];
        // 稀疏数组赋值：先给稀疏数组的第一行的三个列赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        // 遍历二维数组，把非 0 数据存放到稀疏数组中
        int count = 0; //count 用于记录是第几个非0数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArray1[i][j];
                }
            }
        }
        // 打印稀疏数组的数据格式
        System.out.println();
        System.out.println("得到稀疏数组为--->");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        // 将稀疏数组恢复成原始二维数组
        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组

        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可

        for(int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }

}
