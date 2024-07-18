import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] sequence = new int[n+1];
        int[] DP = new int[n+1];

        for (int i=1; i<=n; i++) {
            sequence[i] = sc.nextInt();
        }


        // DP[1] = 1;
        for (int i=1; i<=n; i++) {
            int maxLength = -1; //매번 초기화

            if (i == 1){
                DP[i] = 1;
                continue;
            }

            for (int j=i-1; j>=1; j--) {
                if (sequence[j] > sequence[i]) {
                    if (maxLength < DP[j]+1) {
                        maxLength = DP[j] + 1;
                    }
                }
            }
            
            if (maxLength == -1) {
                DP[i] = 1;
            } else {
                DP[i] = maxLength;
            }
        }

        int totalMaxLength = 0;
        for (int elem: DP) {
            // System.out.print(elem + " ");
            if (totalMaxLength < elem) {
                totalMaxLength = elem;
            }
        }
        System.out.println(totalMaxLength);

        
    }
}