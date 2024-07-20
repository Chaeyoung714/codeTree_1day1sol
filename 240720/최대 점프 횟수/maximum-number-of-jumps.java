import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] locations = new int[n];
        int[] DP = new int[n];

        for (int i=0; i<n; i++) {
            locations[i] = sc.nextInt();
        }

        for (int i=0; i<n; i++) {
            if (i == 0) {
                DP[i] = 0;
                continue;
            }

            int maxJump = -1;

            for (int j=0; j<i; j++) {
                if (j + locations[j] >= i) {
                    maxJump = Math.max(maxJump, DP[j]);
                }
            }

            if (maxJump == -1) { //i 위치로 올수있는 방법이 없으면
                DP[i] = 0; 
            } else {
                DP[i] = maxJump + 1;
            }
        }

        int result = -1;
        for (int elem: DP) {
            result = Math.max(result, elem);
        }
        System.out.println(result);
    }
}