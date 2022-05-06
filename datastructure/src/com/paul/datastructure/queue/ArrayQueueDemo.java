package com.paul.datastructure.queue;

import java.util.Scanner;

/**
 * @Desc: 数据结构 ---> 队列
 * @Date: 2022-05-06 21:24
 * @Author: paul
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        // 当前用数组实现的队列还存在bug，数组队列使用一次就不能再次使用了，没有达到服用的效果
        // 优化：将这个数组使用算法，改进成一个环形队列，取模：%

        // 测试队列，模拟一个操作界面，根据用户输入指令，执行对应队列功能
        // 创建一个指定容量大小的队列
        ArrayQueue arrayQueue = new ArrayQueue(3);

        // 用于接收用户在操作界面输入的操作命令
        char key;
        // 创建一个用于扫描用户输入文本的类Scanner(该类会在控制台一直等待输入，然后扫描输入的文本值，敲下回车时结束等待)
        // 然后使用Scanner中的nextLine()方法去获取输入的内容
        Scanner scanner = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            // 功能提示界面
            System.out.println("功能提示界面(●'◡'●)：");
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：向队列添加数据一个数字");
            System.out.println("g(get)：从队列获取数据");
            System.out.println("h(head)：查看队列头部数据");
            System.out.println("e(exit)：退出程序");
            // 接收用户在操作界面输入的命令
            key = scanner.next().charAt(0);
            switch (key) {
                // 显示队列数据
                case 's':
                    try {
                        arrayQueue.showAllQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                // 添加数据到队列
                case 'a':
                    try {
                        System.out.println("请输入一个要加入队列的数字：");
                        int value = scanner.nextInt();
                        arrayQueue.addQueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    // 取出数据
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.showHeadQueueData();
                        System.out.printf("队列头的数据是：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("请输入正确的功能指令");
                    break;
            }
        }
        System.out.println("程序已退出O(∩_∩)O");
    }

}

class ArrayQueue {

    // 队列的最大容量
    private int maxSize;
    // 队列的头位置
    private int front;
    // 队列的尾位置
    private int rear;
    // 用于存放队列的数据，用数组模拟队列
    private int[] arr;

    // 创建构造器
    public ArrayQueue(int arrMaxSize) {
        // 根据构造器传入的队列大小，队列初始化容量大小初始化，如果为0，则队列默认大小为8
        this.maxSize = arrMaxSize == 0 ? 8 : arrMaxSize;
        // 根据构造器传入的队列大小，初始化一个相同大小的数组
        this.arr = new int[arrMaxSize];
        // 初始化队列头部位置，用于分析front是指向队列头的前一个位置
        this.front = -1;
        // 初始化队列的尾位置，用于指向队列尾部的数据（也就是队列中最后一个位置的数据）
        this.rear = -1;
    }

    // 判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 向队列添加数据
    public void addQueue(int num) {
        // 首先判断队列是否已满，若已满，则不能继续添加数据
        if (isFull()) {
            System.out.println("队列已满，添加数据入队失败！");
            return;
        }
        // 尾指针后移
        rear++;
        arr[rear] = num;
    }

    // 按顺序从队列中获取一个数据，数据出队
    public int getQueue() {
        // 首先判断队列是否为空，如果为空，则提示队列为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取队列数据！");
            //System.out.println("队列为空，无法获取队列数据！");
        }
        // 头指针后移一位
        front++;
        return arr[front];
    }

    // 显示队列所有数据
    public void showAllQueue() {
        // 首先判断队列是否为空，如果为空，则提示队列为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取队列数据！");
            //System.out.println("队列为空，无法获取队列数据！");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列的头数据（不是从队列中取出数据）
    public int showHeadQueueData() {
        // 首先判断队列是否为空，如果为空，则提示队列为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取队列数据！");
            //System.out.println("队列为空，无法获取队列数据！");
        }
        return arr[front + 1];
    }

}