import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] DP = new int[n+1];

        if (n <= 3) {
            System.out.println(1);
        } else {
            //초기화
            DP[1] = 0;
            DP[2] = 1;
            DP[3] = 1;

            for (int i=4; i<=n; i++) {
                DP[i] = DP[i-2] + DP[i-3];
            }

            System.out.println(DP[n]);
        }
    }
}