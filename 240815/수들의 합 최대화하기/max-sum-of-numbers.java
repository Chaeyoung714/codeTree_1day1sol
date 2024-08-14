import java.util.Scanner;

public class Main {
    public static int n, maxSum;
    public static int[][] nums;
    public static int[] visited;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        maxSum = -1;
        visited = new int[n]; //중복 여부를 체크하기 위해.
        findMaxSum(0, 0); //0~n-1

        System.out.println(maxSum);
    }

    public static void findMaxSum(int sum, int row) {
        if (row >= n) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int col=0; col<n; col++) {
            if (visited[col] == 0) {
                visited[col] = 1;
                findMaxSum(sum + nums[row][col], row + 1);
                visited[col] = 0; //원복
            }
        }
    }
}