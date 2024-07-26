import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] DP = new int[m+1];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i=0; i<=m; i++) {
            if (i == 0) {
                DP[i] = 0;
            } else {
                DP[i] = -1;
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=m; j>=0; j--) {
                if (j >= arr[i]) {
                    if (DP[j-arr[i]] == -1) {
                        continue;
                    }
                    DP[j] = Math.max(DP[j], DP[j-arr[i]] + 1);
                }
            }
        }

        if (DP[m] == -1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}