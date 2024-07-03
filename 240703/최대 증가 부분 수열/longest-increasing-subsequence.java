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

        int result = 0;
        for (int i=0; i<n; i++) {
            if (i == 0) {
                DP[i] = 1;
            } else {
                int maxLgth = 0;
                for (int j=0; j<i; j++) {
                    if (nums[j] < nums[i] && maxLgth < DP[j]) { //i번째가 증가수열에 포함되면
                        maxLgth = DP[j];
                    }
                }
                maxLgth++;
                
                // DP[i] = Math.max(DP[i-1], maxLgth);
                DP[i] = maxLgth;
            }

            if (DP[i] > result) {
                result = DP[i];
            }
        }

        System.out.println(result);
    }
}