import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //배열 채움 - 효율적인 방식 외워두기
        int[][] grid = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int total;
        int maxTotal = 0;
        for (int i=0; i<n-2; i++) {
            for (int j=0; j<n-2; j++) {
                total = 0;
                for (int d=0; d<3; d++) {
                    total += (grid[i+d][j] + grid[i+d][j+1] + grid[i+d][j+2]);
                }
                if (maxTotal < total) {
                    maxTotal = total;
                }
            }
        }

        System.out.println(maxTotal);
    }
}