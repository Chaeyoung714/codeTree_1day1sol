import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] DP = new int[n+1];

        for (int i=1; i<=n; i++) {
            if (i == 1 || i == 2 || i == 5) {
                DP[i] += 1;
            }
            if (i > 1 && i <= 2) {
                DP[i] += (DP[i-1]);
            } else if (i > 2 && i <= 5) {
                DP[i] += (DP[i-1] + DP[i-2]);
            } else if (i > 5) {
                DP[i] += (DP[i-1] + DP[i-2] + DP[i-5]) % 10007;
            }
        }

        System.out.println(DP[n]);
    }
}