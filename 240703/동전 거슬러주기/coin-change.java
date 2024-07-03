import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int m;
    public static int[] coins, DP;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        coins = new int[n];
        DP = new int[m+1]; //0은 쓰지 않음
        for (int i=0; i<n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);

        boolean satisfied; 

        for (int i=1; i<coins[0]; i++) {
            DP[i] = -1; //사용불가 
        }

        for (int total=1; total<=m; total++) { //모든 합에 대해
            // countCoins(i);
            satisfied = false;
            int minSum = Integer.MAX_VALUE;

            for (int coin: coins) {
                if (total >= coin && DP[total-coin] != -1) {
                    satisfied = true;
                    minSum = Math.min(DP[total-coin], minSum);
                }
            }

            if (satisfied) {
                DP[total] = minSum + 1;
            } else {
                DP[total] = -1;
            }
        }

        System.out.println(DP[m]);
    }

    public static void countCoins(int i) {
        
    }
}