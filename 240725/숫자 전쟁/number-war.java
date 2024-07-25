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
        for (int i=0; i<n; i++) {
            if (first[i] > second[0]) { //점수 획득 <가능!!!>
                if (i == 0) {
                    DP[i][0] = second[0];
                } else {
                    if (first[i-1] < second[0]) { DP[i][0] = DP[i-1][0] + second[0]; }
                    else { DP[i][0] = 0; }
                }
            } else {
                if (i == 0) {
                    DP[i][0] = 0;
                } else {
                    if (first[i-1] < second[0]) { DP[i][0] = DP[i-1][0];} 
                    else { DP[i][0] = 0; }
                }
            }
        }
        for (int j=1; j<n; j++) {
            if (second[j] < first[0]) { //점수 획득 <가능>
                if (second[j-1] < first[0]) { DP[0][j] = DP[0][j-1] + second[j];}
                else { DP[0][j] = 0; }
            } else {
                if (second[j-1] < first[0]) { DP[0][j] = DP[0][j-1]; }
                else { DP[0][j] = 0; }
            }
        }

        //DP채움
        for (int i=1; i<n; i++) { //n >= 2이므로 이렇게 가능
            for (int j=1; j<n; j++) {

                // DP[i][j] = Math.max(DP[i-1][j-1], DP[i][j-1]);
                // DP[i][j] = Math.max(DP[i][j], DP[i-1][j]);

                int maxLastCase = -1;
                //[i][j-1] -> [i][j] : 남우가 승리한 경우 직전 상황 가능
                if (second[j-1] < first[i]) {
                    if (maxLastCase < DP[i][j-1]) {
                        maxLastCase = DP[i][j-1];
                    }
                }
                //[i-1][j], [i-1][j-1] -> [i][j] : 상대가 카드를 버린 경우 = 남우가 이기지 않은 경우 직전 상황 가능
                if (second[j] > first[i-1]) {
                    if (maxLastCase < DP[i-1][j]) {
                        maxLastCase = DP[i-1][j];
                    }
                }
                if (second[j-1] >= first[i-1]) {
                    if (maxLastCase < DP[i-1][j-1]) {
                        maxLastCase = DP[i-1][j-1];
                    }
                }

                if (maxLastCase == -1) { //해당 케이스에 도달 불가
                    DP[i][j] = 0;
                } else {
                    DP[i][j] += maxLastCase;

                    if (first[i] > second[j]) { //남우가 이겼는데도 둘다 카드버리기를 선택하는 경우가 있을까..?
                        DP[i][j] += second[j];
                    }
                }
            }
        }

        // for (int[] arr: DP) {
        //     for (int elem: arr) {
        //         System.out.print(elem + " ");
        //     }
        //     System.out.println();
        // }

        int maxScore = -1;
        for (int i=0; i<n; i++) {
            maxScore = Math.max(maxScore, DP[i][n-1]);
        }
        for (int j=0; j<n; j++) {
            maxScore = Math.max(maxScore, DP[n-1][j]);
        }
        System.out.println(maxScore);
    }


            // //초기화
        // int[] result = new int[2];
        // if (first[0] > second[0]) {
        //     DP[0][0] = second[0];
        //     result = playGame(0, 1, 0, 0);
        // } else if (first[0] < second[0]) {
        //     DP[0][0] = 0;
        //     result = playGame(1, 0, 0, 0);
        // } else {
        //     DP[0][0] = 0;
        //     result = playGame(1, 1, 0, 0);
        // }
        
        // for (int[] arr: DP) {
        //     for (int elem: arr) {
        //         System.out.print(elem + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(result[0] + ", " + result[1]);
        // System.out.println(DP[result[0]][result[1]]);
    // public static int[] playGame(int i, int j, int li, int lj) {
    //     int iFinal = -1;
    //     int jFinal = -1;

    //     while (true) {
    //         if (i == n || j == n) {
    //             iFinal = li;
    //             jFinal = lj;
    //             break;
    //         }
    //         if (first[i] > second[j]) {
    //             DP[i][j] = DP[li][lj] + second[j];
    //             li = i;
    //             lj = j;
    //             j++;
    //         } else if (first[i] < second[j]) {
    //             DP[i][j] = DP[li][lj];
    //             li = i;
    //             lj = j;
    //             i++;
    //         } else {
    //             DP[i][j] = DP[li][lj];
    //             li = i;
    //             lj = j;
    //             i++;
    //             j++;
    //         }
    //     }

    //     return new int[] {iFinal, jFinal};
}