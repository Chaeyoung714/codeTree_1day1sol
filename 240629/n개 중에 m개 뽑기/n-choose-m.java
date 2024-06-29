import java.util.Scanner;

public class Main {
    public static int n, m;
    public static int[] arr;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        choose(0, 1);
    }

    public static void choose(int depth, int nextVal) {
        if (depth > m-1) {
            for (int elem: arr) {
                System.out.print(elem + " ");
            }
            System.out.println();
            return;
        }

        if (nextVal > n) {
            return;
        }

        for (int val=nextVal; val<=n; val++) {
            arr[depth] = val;
            choose(depth+1, val+1);
        }
    }
}