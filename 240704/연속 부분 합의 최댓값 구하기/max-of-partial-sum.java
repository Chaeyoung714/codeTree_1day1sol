import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] DP = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        DP[0] = arr[0] * 2;
        int maxSum = DP[0];
        for (int i=1; i<n; i++) {
            DP[i] = Math.max(DP[i-1], 2*arr[i]);
            if (maxSum < DP[i]) {
                maxSum = DP[i];
            }
        }

        System.out.println(maxSum);
    }
}