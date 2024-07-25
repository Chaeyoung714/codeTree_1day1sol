import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static int[] arr, DP;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n];
        DP = new int[m+1];

        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        //초기화
        DP[0] = 0;
        for (int i=1; i<=m; i++) {
            DP[i] = MAX_VALUE;
        }

        Arrays.sort(arr); 

        for (int i=0; i<n; i++) {
            for (int j=m; j>=0; j--) {
                if (j >= arr[i]) {
                    if (DP[j-arr[i]] == MAX_VALUE) {
                        continue;
                    }
                    DP[j] = Math.min(DP[j], DP[j-arr[i]] + 1);
                }
            }
        }

        // for (int elem: DP) {
        //     System.out.print(elem + " ");
        // }

        if (DP[m] == MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(DP[m]);
        }

        // for (int total=1; total<=m; total++) {
        //     int minLen = MAX_VALUE;
        //     for (int i=0; i<n; i++) {
        //         if (arr[i] <= total && DP[total-arr[i]] != -1 ) {
        //             minLen = Math.min(DP[total-arr[i]], minLen);
        //         }
        //     }
        //     if (minLen == MAX_VALUE) {
        //         continue; //DP[total] = -1
        //     } else {
        //         DP[total] = minLen + 1;
        //     }
        // }

        // System.out.println("DPDPDPDDPDPDP");
        // for (int elem: DP) {
        //     System.out.print(elem + " ");
        // }
        // System.out.println();
        // System.out.println(DP[m]);

        
    }
}