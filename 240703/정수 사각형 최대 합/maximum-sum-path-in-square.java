import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        int[][] DP = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        //초기화
        for (int i=0; i<n; i++) {
            if (i == 0) {
                DP[0][i] = grid[0][i];
            } else {
                DP[0][i] = grid[0][i] + DP[0][i-1];
            }
        }
        for (int i=0; i<n; i++) {
            if (i == 0) {
                DP[i][0] = grid[i][0];
            } else {
                DP[i][0] += grid[i][0] + DP[i-1][0];
            }
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<n; j++) {
                DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]) + grid[i][j];
            }
        }

        System.out.println(DP[n-1][n-1]);
    }
}