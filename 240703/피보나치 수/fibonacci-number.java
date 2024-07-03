import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] DP = new int[n+1];

        for (int i=1; i<=n; i++) {
            if (i <= 2) { //arraydoutofbound 에러 방지
                DP[i] = 1;
            }  else {
                DP[i] = DP[i-1] + DP[i-2];
            }
        }

        System.out.println(DP[n]);
    }
}