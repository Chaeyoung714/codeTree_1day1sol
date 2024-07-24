import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] first, second;
    public static int[][] DP;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        first = new int[n];
        second = new int[n];
        DP = new int[n][n];
        
        for (int i=0; i<n; i++) {
            first[i] = sc.nextInt();
        }
        for (int i=0; i<n; i++) {
            second[i] = sc.nextInt();
        }

        //초기화
        int[] result = new int[2];
        if (first[0] > second[0]) {
            DP[0][0] = second[0];
            result = playGame(0, 1, 0, 0);
        } else if (first[0] < second[0]) {
            DP[0][0] = 0;
            result = playGame(1, 0, 0, 0);
        } else {
            DP[0][0] = 0;
            result = playGame(1, 1, 0, 0);
        }
        
        // for (int[] arr: DP) {
        //     for (int elem: arr) {
        //         System.out.print(elem + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(result[0] + ", " + result[1]);
        System.out.println(DP[result[0]][result[1]]);

        // //초기화
        // for (int i=0; i<n; i++) {
        //     if (first[i] > second[0]) { //점수 획득
        //         if (i == 0) {
        //             DP[i][0] = first[i];
        //         } else {
        //             DP[i][0] = DP[i-1][0] + first[i];
        //         }
        //     } else {
        //         if (i == 0) {
        //             DP[i][0] = 0;
        //         } else {
        //             DP[i][0] = DP[i-1][0];
        //         }
        //     }
        // }
        // for (int j=0; j<n; j++) {
        //     if (second[j] < first[0]) {
        //         if (j == 0) {
        //             DP[0][j] = second[0];
        //         } else {
        //             DP[0][j] = DP[0][j-1] + second[j];
        //         }
        //     } else {
        //         if (j == 0) {
        //             DP[0][j] = 0;
        //         } else {
        //             DP[0][j] = DP[0][j-1];
        //         }
        //     }
        // }

        // //DP채움
        // for (int i=1; i<n; i++) { //n >= 2이므로 이렇게 가능
        //     for (int j=1; j<n; j++) {
        //         DP[i][j] = Math.max(DP[i-1][j-1], DP[i][j-1], DP[i-1][j]);


        //         if (first[i] > second[j]) {
        //             DP[i][j] += second[j];
        //         }
        //     }
        // }
    }

    public static int[] playGame(int i, int j, int li, int lj) {
        int iFinal = -1;
        int jFinal = -1;

        while (true) {
            if (i == n || j == n) {
                iFinal = li;
                jFinal = lj;
                break;
            }
            if (first[i] > second[j]) {
                DP[i][j] = DP[li][lj] + second[j];
                li = i;
                lj = j;
                j++;
            } else if (first[i] < second[j]) {
                DP[i][j] = DP[li][lj];
                li = i;
                lj = j;
                i++;
            } else {
                DP[i][j] = DP[li][lj];
                li = i;
                lj = j;
                i++;
                j++;
            }
        }

        return new int[] {iFinal, jFinal};
    }
}