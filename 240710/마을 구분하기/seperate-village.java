import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static int n, cnt;
    public static int totalCnt = 0;
    public static int[][] village;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean inRange(int i, int j) {
        return (i >= 0 && i < n && j >= 0 && j < n);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        village = new int[n][n];
        ArrayList<Integer> countArr = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                village[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (village[i][j] == 1) {
                    cnt = 1;
                    dfs(i, j);
                    totalCnt++;
                    countArr.add(cnt);
                }
            }
        }

        // countArr.sort(Comparator.naturalOrder());
        Collections.sort(countArr);
        System.out.println(totalCnt);
        for (int elem: countArr){
            System.out.println(elem);
        }

        

    }

    public static void dfs(int x, int y) {
        boolean satisfied = false; //현재 위치 기준 dfs 가능한지 판단

        village[x][y] = 0;

        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (inRange(nx, ny) && village[nx][ny] == 1) {
                satisfied = true;
                cnt++;
                dfs(nx, ny);
            }
        }

        if (!satisfied) {//더이상 진행 불가
            return;
        }
        // return; //함수가 완전히 끝났을때 return
    }
}