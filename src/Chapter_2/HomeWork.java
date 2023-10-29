package Chapter_2;

/**
 * @Description:第二章作业
 * @Author:Xiongbing
 * @Date:2023/10/29 16:45
 */
import java.util.Scanner;
public class HomeWork {
    static int[] h = new int[5000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入栅栏的个数：");
            int n = sc.nextInt();
            // 读取高度数据
            System.out.print("请输入每一个栅栏的高度：");
            for (int i = 1; i <= n; i++) {
                h[i] = sc.nextInt();
            }
            int ans = dfs(1, n);
            System.out.println("最少" + ans + "次就能够刷完！");
        }
    }
    // DFS递归函数,计算从L到R区间的最大高度和
    public static int dfs(int L, int R) {
        int pre = L; // 记录前一个位置
        int ans = 0;
        if (L > R)
            return 0; // 终止条件
        int minn = Integer.MAX_VALUE; // 记录最小高度

        // 找到区间内最小高度
        for (int i = L; i <= R; i++) {
            minn = Math.min(minn, h[i]);
        }
        // 减去最小高度
        for (int i = L; i <= R; i++) {
            h[i] -= minn;
        }
        ans += minn; // 最小高度部分加到答案
        // 遍历区间
        for (int i = L; i <= R; i++) {
            if (h[i] == 0) { // 遇到高度为0的位置
                // 左边界到当前位置的最大高度和
                ans += dfs(pre, i-1);
                pre = i + 1; // 更新左边界
            }
            if (i == R) { // 到达右边界
                if (h[i] > 0) {
                    ans += dfs(pre, R); // 右边还有高度需要处理
                } else {
                    ans += dfs(pre, R-1); // 右边全为0,不用处理最后一个
                }
            }
        }
        return Math.min(ans, R - L + 1); // 答案取区间长度和递归结果中的最小值
    }
}
