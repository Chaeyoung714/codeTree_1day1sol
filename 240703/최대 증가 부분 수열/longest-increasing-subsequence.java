import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] DP = new int[n];

        for (int i=0; i<n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i=0; i<n; i++) {
            if (i == 0) {
                DP[i] = 1;
                continue;
            }

            int maxLgth = 0;
            for (int j=0; j<i; j++) {
                if (nums[j] < nums[i]) {
                    if (maxLgth < DP[j]) {
                        maxLgth = DP[j];
                    }
                }
            }
            maxLgth++;
            
            DP[i] = Math.max(DP[i-1], maxLgth);
        }

        System.out.println(DP[n-1]);
    }
}