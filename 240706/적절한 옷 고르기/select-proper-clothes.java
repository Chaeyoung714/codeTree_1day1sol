import java.util.Scanner;

public class Main {

    public static int n, m;
    public static int[][] clothes, DP;
    public static boolean isWearable(int i, int j) { //입을 수 있으면 true 반환
        return clothes[i][j] != 0;
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();//옷 개수
        m = sc.nextInt();//날짜 수

        clothes = new int[m+1][n+1]; //0은 쓰지 않음 
        DP = new int[m+1][n+1];

        for (int j=1; j<=n; j++) {
            int s = sc.nextInt(); //해당 옷을 입기 시작한 날짜
            int e = sc.nextInt(); //해당 옷을 입을 수 있는 마지막 날짜
            int v = sc.nextInt();
            for (int i=s; i<=e; i++) { //옷을 입을 수 있는 날엔 화려함값, 없는 날엔 0으로 채워짐 
                clothes[i][j] = v;
            }
        }

        // 초기화 : DP[1][k] = 모두 0
        for (int j = 1; j <= n; j++) {
            DP[1][j] = 0; // 첫 날은 화려함이 0
        }


        for (int i=2; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (isWearable(i, j)) {
                    chooseCloth(i, j);
                }
            }
        }


        int maxResult = -1;
        for (int elem: DP[m]) {
            if (maxResult < elem) {
                maxResult = elem;
            }
        }
        System.out.println(maxResult);
    }

    public static void chooseCloth(int day, int cloth) {
        int maxGap = -Integer.MAX_VALUE;
        int maxGapIdx = -1;
        int v = clothes[day][cloth]; //현재 옷의 화려함값 

        for (int k=1; k<=n; k++) {
            if (isWearable(day-1, k)) {
                int gap = Math.abs(v - clothes[day-1][k]);
                // System.out.println("gap= " + gap);
                if (gap > maxGap) {
                    maxGap = gap;
                    maxGapIdx = k;
                }
            }
        }
        // DP[day][cloth] = DP[day-1][maxGapIdx] + maxGap;

        DP[day][cloth] = DP[day-1][maxGapIdx] + maxGap;

        return;
    }
}