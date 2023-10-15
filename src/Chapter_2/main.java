package Chapter_2;

import java.util.Scanner;

/**
 * @Description:递归的概念
 * @Author:Xiongbing
 * @Date:2023/10/14 14:44
 */
public class main {
    public static void main(String[] args) {
        System.out.println("请输入一个数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = factorial(n);
        System.out.println(n + "的阶乘为：" + result);

        int result1 = fibonacci(n);
        System.out.println(n + "斐波拉契数列和为：" + result1);
        //全排列
        int []list = {1,4,8,5,18,40,4,7,5,20,};
        Perm(list,2,3);

        // 整数划分问题
        System.out.print("请输入你要划分的整数：");
        int num = sc.nextInt();
        System.out.print("请输入划分的最大加数：");
        int max_num = sc.nextInt();
        System.out.println("总共的划分数为：" + num_addition(num,max_num));

        // 汉诺塔问题
        System.out.print("请输入盘子的个数：");
        int num1 = sc.nextInt();
        String a = "A柱";
        String b = "B柱";
        String c = "C柱";
        hanoi(num1,a,b,c);


    }
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static int fibonacci(int n){
        if(n <= 1){
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void Perm(int []list,int k,int m){
        if(k == m){
            for (int i = 0; i <= m; i++) {
                System.out.print(list[i] + ",");
            }
            System.out.println();
        }else{
            for (int i = k; i <= m; i++) {
                Swap(list,k,i);
                Perm(list,k + 1,m);
                Swap(list,k,i);
            }
        }
    }
    public static void Swap(int []list,int a,int b){
        int temp;
        temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
    public static int num_addition(int n,int m){
        if(n < 1 || m < 1){
            return 0;
        } else if (n == 1 || m == 1) {
            return 1;
        } else if (n < m) {
            return num_addition(n,n);
        } else if (n == m) {
            return num_addition(n,m - 1) + 1;
        }
        return num_addition(n,m - 1) + num_addition(n - m,m);
    }
    public static void hanoi(int n,String a,String b,String c){
        if(n == 1){
            System.out.println("把第1个盘从" + a + "移动到" + c);
        } else {
            hanoi(n - 1,a,c,b);
            System.out.println("把第"+ n + "个盘从" + a + "移动到" + c);
            hanoi(n - 1,b,a,c);
        }
    }
}
