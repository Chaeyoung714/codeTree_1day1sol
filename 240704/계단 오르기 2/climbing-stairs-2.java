import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coins = new int[n+1];
        int[][] DP = new int[n+1][4];

        for (int i=1; i<=n; i++) {
            coins[i] = sc.nextInt();
        }

        //초기화
        DP[1][1] = coins[1]; //1층을 1계단*1으로 가는 경우
        DP[2][0] = coins[2]; //2층을 1계단*2로 가는 경우
        for (int i=2; i<=n; i+=2) {//짝수층일때 2계단으로만 올 수 있음
            if (i == 2) {
                DP[i][0] = coins[i];
            } else {
                DP[i][0] = DP[i-2][0] + coins[i];
            }
        }

        for (int i=2; i<=n; i++) {
            for (int j=1; j<=3; j++) {
                DP[i][j] = Math.max(DP[i-1][j-1], DP[i-2][j]) + coins[i];
            }
        }

        int maxCoin = 0;
        for (int elem: DP[n]) {
            // System.out.print(elem + " ");
            if (maxCoin < elem) {
                maxCoin = elem;
            }
        }
        System.out.println(maxCoin);
    }
}