import java.util.Scanner;

public class Main {
    public static int n, k;
    public static int endOfResult = 0;
    public static int[][] result;
    public static int[] arr;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        result = new int[1000000][n];
        arr = new int[n];

        choose(0); //0자리수(첫번째)부터 백트래킹 시작 

        // for (int[] elemArr: result) {
        //     for (int elem: elemArr) {
        //         System.out.print(elem + " ");
        //     }
        //     System.out.println();
        // }
    }

    public static void choose(int depth) {
        if (depth > n-1) { //종료조건
            for (int i=0; i<n; i++) {
                result[endOfResult++][i] = arr[i];
            }
            result[endOfResult++] = arr;

            for (int elem: arr) {
                System.out.print(elem + " ");
            }
            System.out.println();
            return;
        }

        for (int val=1; val<=k; val++) {
            arr[depth] = val;
            choose(depth+1);
        }
    }
}