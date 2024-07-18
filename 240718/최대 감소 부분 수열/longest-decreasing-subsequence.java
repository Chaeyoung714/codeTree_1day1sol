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
            boolean satisfied = false; //매번 초기화

            if (i == 1){
                DP[i] = 1;
                continue;
            }

            for (int j=i-1; j>=1; j--) {
                if (sequence[j] > sequence[i]) {
                    DP[i] = DP[j] + 1;
                    satisfied = true;
                    break;
                }
            }
            
            if (!satisfied) {
                DP[i] = 1;
            }
        }

        int maxLength = 0;
        for (int elem: DP) {
            if (maxLength < elem) {
                maxLength = elem;
            }
        }
        System.out.println(maxLength);


    }
}