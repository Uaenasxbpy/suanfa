package Chapter_2;

import java.util.Scanner;

/**
 * @Description:分治策略设计技巧
 * @Author:Xiongbing
 * @Date:2023/10/14 16:35
 */
public class Divide {
    public static void main(String[] args) {
        // 二分搜索技术
        System.out.print("请输入你要搜索的数字：");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int []list = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int n = list.length;
        int result = BinarySearch(list,x,n);
        if (result == -1){
            System.out.println("没有找到该数字！");
        }else{
            System.out.println("该数字的位置为：" + result);
        }

        // 大整数乘法
        // Strassen矩阵乘法
        // 棋盘覆盖
        // 合并排序与快速排序
        // 线性时间选择
        // 最接近点对问题
        // 循环赛日程表
    }
    public static int BinarySearch(int []list,int x,int n){
        int left = 0;
        int right = n - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if(x == list[middle]){
                return middle;
            } else if (x > list[middle]) {
                left = middle + 1;
            }else {
                right = middle - 1;
            }
            // System.out.println(middle);
        }
        return -1;
    }
}
