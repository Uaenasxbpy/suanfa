package Chapter_2;

import java.util.Scanner;

/**
 * @Description:分治策略设计技巧
 * @Author:Xiongbing
 * @Date:2023/10/14 16:35
 */
public class Divide {

    public static int title = 0;
    public static int [][]Board;
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
//        分治算法 O(n^2 -> 3T(n / 2) + O(n))
        // Strassen矩阵乘法
//        8T(n / 2) + O(n^2) -> 7T(n / 2) + O(n^2)

        // 棋盘覆盖
        Board = new int[100][100];
        int tr = 0,tc= 0;
        System.out.println("请输入特殊棋子的位置（开始为第0行，第0列）");
        System.out.print("请输入行号：");
        int dr = sc.nextInt();
        System.out.print("请输入列号：");
        int dc = sc.nextInt();
        System.out.print("请输入棋盘的大小（棋盘大小为2^k）");
        int size = sc.nextInt();
        ChessBoard(tr,tc,dr,dc,size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(Board[i][j] + " ");
            }
            System.out.println();
        }
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
    public static void ChessBoard(int tr,int tc,int dr,int dc,int size){
//        tr,tc : 棋盘左上角的行号和列号
//        dr,dc : 棋盘特殊方格所在的的行号和列号
//        size:棋盘的规格 size * size ,size = 2^k
        if (size == 1){
            return;
        }
        int t = ++title;
        int s = size / 2;
        // 覆盖左上角
        if (dr < tr + s && dc < tc + s){
            // 特殊棋子在里面
            ChessBoard(tr, tc, dr, dc, s);
        }else {
            // 反之，不在里面
            Board[tr + s - 1][tc + s - 1] = t;
            ChessBoard(tr, tc, tr + s - 1, tc + s - 1, s);
        }
        // 覆盖右上角
        if (dr < tr + s && dc >= tc + s){
            // 特殊棋子在里面
            ChessBoard(tr, tc + s, dr, dc, s);
        }else {
            // 反之，不在里面
            Board[tr + s - 1][tc + s] = t;
            ChessBoard(tr, tc + s, tr + s - 1, tc + s, s);
        }
        // 覆盖左下角
        if (dr >= tr + s && dc < tc + s){
            // 特殊棋子在里面
            ChessBoard(tr + s, tc, dr, dc, s);
        }else {
            // 反之，不在里面
            Board[tr + s][tc + s - 1] = t;
            ChessBoard(tr + s, tc, tr + s, tc + s - 1, s);
        }
        // 覆盖右下角
        if (dr >= tr + s && dc >= tc + s){
            // 特殊棋子在里面
            ChessBoard(tr + s, tc + s, dr, dc, s);
        }else {
            // 反之，不在里面
            Board[tr + s][tc + s] = t;
            ChessBoard(tr + s, tc + s, tr + s, tc + s, s);
        }
    }
}
