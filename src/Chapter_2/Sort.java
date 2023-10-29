package Chapter_2;
import java.util.Random;

/**
 * @Description:合并排序与快速排序
 * @Author:Xiongbing
 * @Date:2023/10/29 12:54
 */
public class Sort {
    public static int []a;
    public static int []b;

    public static void main(String[] args) {
        // 合并排序
        a = new int[10];
        b = new int[20];
        int num = a.length;
        Random r= new Random();
        for (int i = 0; i < num; i++) {
            int n = r.nextInt(50) + 1;
            a[i] = n;
            System.out.print(n + ",");
        }
        System.out.println();
//      System.out.println(num);
//      MergeSort(a,0,a.length);
//      快速排序
        QuickSort(a,0,num - 1);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }
    public static void MergeSort(int a[], int left, int right) {
        if (left < right) {
            int i = (left + right) / 2;
            MergeSort(a, left, i);
            MergeSort(a, i + 1, right);
            System.out.print("+");
            Merge(a, left, i, right);
        }
    }

    public static void Merge(int a[], int left, int m, int right) {
        int i = left, j = m + 1, k = left;
        int[] b = new int[right - left + 1]; // Initialize the temporary array
        while (i <= m && j <= right) {
            if (a[i] <= a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }
        for (int q = i; q <= m; q++) {
            b[k++] = a[q];
        }
        for (int q = j; q <= right; q++) {
            b[k++] = a[q];
        }
        for (int q = 0; q < k; q++) {
            a[left + q] = b[q];
        }
    }
    public static void QuickSort(int a[],int p,int r){
        if(p < r){
            int q = Partition(a,p,r);
            QuickSort(a,p,q - 1);
            QuickSort(a,q + 1,r);
        }
    }

    private static int Partition(int[] a, int p, int r) {
        int i = p,j = r + 1;
        int x = a[p];
        while (true){
            while (a[++i] < x && i < r);
            while (a[--j] > x);
            if(i >= j)
                break;
            Swap(a,i,j);
        }
        a[p] = a[j];
        a[j] = x;
        for (int value:a) {
            System.out.print(value + " ");
        }
        System.out.println();
        return j;
    }

    private static void Swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
