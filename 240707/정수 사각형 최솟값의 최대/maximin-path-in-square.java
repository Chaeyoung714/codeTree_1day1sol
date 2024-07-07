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

        DP[0][0] = grid[0][0];
        for (int i=1; i<n; i++) {
            DP[i][0] = Math.min(DP[i-1][0], grid[i][0]);
        }
        for (int j=1; j<n; j++) {
            DP[0][j] = Math.min(DP[0][j-1], grid[0][j]);
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<n; j++) {
                if (grid[i][j] <= Math.min(DP[i-1][j], DP[i][j-1])) { //모든 경로에서 최소임 -> 모든 경로에서 최솟값으로 등록
                    DP[i][j] = grid[i][j];
                } else { //else: 두 경로 각각 최솟값 존재 -> 더 큰 값 저장 
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
                }
            }
        }

        // for (int[] arr: DP) {
        //     for (int elem: arr) {
        //         System.out.print(elem + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(DP[n-1][n-1]);
    }
}