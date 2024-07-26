import java.util.Scanner;

public class Main {
    public static int[][] DP;
    public static String[] arrA, arrB;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        arrA = sc.nextLine().split("");
        arrB = sc.nextLine().split("");

        int lenA = arrA.length;
        int lenB = arrB.length;

        DP = new int[lenA+1][lenB+1];

        // 초기화
        for (int i=0; i<=lenA; i++) {
            DP[i][0] = i; //i번 삭제
        }
        for (int j=0; j<=lenB; j++) {
            DP[0][j] = j; //j번 삽입
        }

        //DP
        for (int i=1; i<=lenA; i++) {
            for (int j=1; j<=lenB; j++) {
                int result = -1;
                if (arrA[i-1].equals(arrB[j-1])) { //arrA, arrB는 0에서부터 시작하므로
                    // System.out.println("a = " + arrA[i-1] + " b = " + arrB[j-1]);
                    result = DP[i-1][j-1];
                } else {
                    // System.out.println("a = " + arrA[i-1] + " b = " + arrB[j-1]);
                    result = countIncludingDuplication(i-1, j-1); //arrA, arrB 상에서의 인덱스
                    if (result == -1) {
                        if (i != j) { //len(a) >, < len(b)
                            result = DP[i-1][j]; //삽입, 삭제 - 마지막 글자는 교체로
                        } else {
                            result = DP[i-1][j-1] + 1; //교체
                        }
                    }
                }

                DP[i][j] = result;
            }
        }

        // for (int[] arr: DP) {
        //     for (int elem: arr) {
        //         System.out.print(elem + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(DP[lenA][lenB]);
    }

    public static int countIncludingDuplication(int a, int b) {
        for (int j=b-1; j>=0; j--) {
            if (arrA[a].equals(arrB[j])) { //SAB -> ABA의 경우           
                // System.out.println("a = " + a + arrA[a] + " b = " + j + arrB[j]);
                return DP[a][j] + (b - j); //(SA -> A) + (X -> A)
            }
        }

        return -1;

    }
}