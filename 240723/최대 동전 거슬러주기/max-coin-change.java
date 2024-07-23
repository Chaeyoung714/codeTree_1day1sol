import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coins = new int[n];
        int[] DP = new int[m+1];

        for (int i=-0; i<n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins);

        for (int i=1; i<=m; i++) {
            for (int coin: coins) { //초기화 (픽스는 x)
                if (i == coin) {
                    DP[i] = 1;
                }
            }

            int maxCoin = 0; //직전 케이스(현재케이스 포함 x) 중 최대 동전 개수
            for (int coin: coins) {
                if (i - coin > 0) {
                    maxCoin = Math.max(maxCoin, DP[i-coin]);
                }
            }

            if (maxCoin == 0) {
                continue; //DP[i] = 0 or DP[i] = 1이므로 그대로
            } else {
                DP[i] = maxCoin + 1;
            }
        }

        if (DP[m] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(DP[m]);
        }
    }
}