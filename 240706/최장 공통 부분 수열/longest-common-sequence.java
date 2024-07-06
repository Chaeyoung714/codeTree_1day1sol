import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        String strA = sc.nextLine();
        String strB = sc.nextLine();

        String[] a = strA.split("");
        String[] b = strB.split("");

        int lenA = a.length;
        int lenB = b.length;

        int[][] DP = new int[lenA][lenB];

        //초기화
        boolean satisfied = false;
        for (int i=0; i<lenA; i++) {
            if (satisfied) {
                DP[i][0] = 1;
            } else {
                if (a[i].equals(b[0])) {
                    // DP[i][0] = DP[i-1][0] + 1;
                    satisfied = true;
                    DP[i][0] = 1;
                } else {
                    // DP[i][0] = DP[i-1][0];
                    DP[i][0] = 0;
                }
            }
        }

        satisfied = false;
        for (int j=0; j<lenB; j++) {
            if (satisfied) {
                DP[0][j] = 1;
            } else {
                if (a[0].equals(b[j])) {
                    // DP[0][j] = DP[0][j-1] + 1;
                    satisfied = true;
                    DP[0][j] = 1;
                } else {
                    // DP[0][j] = DP[0][j-1];
                    DP[0][j] = 0;
                }
            }
        }

        //예외 -  왜 따로 빼야하지?
        // if (lenA == 1 || lenB == 1) {
        //     if (satisfied) {
        //         System.out.println(1);
        //     }
        //     else {
        //         System.out.println(0);
        //     }
        // } else {
            //DP채움
        for (int i=1; i<lenA; i++) {
            for (int j=1; j<lenB; j++) {
                if (a[i].equals(b[j])) {
                    DP[i][j] = DP[i-1][j-1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
                }
            }
        }

        System.out.println(DP[lenA-1][lenB-1]);

    }
}