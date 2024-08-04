import java.util.Scanner;

public class Main {
    public static int n, m;
    public static int[][] houses, visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        houses = new int[n][m]; //보존해야햠

        int maxHeight = -1;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                houses[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, houses[i][j]);
            }
        }

        int maxSafeArea = -1;
        int heightOfMaxSafeArea = 0;
        for (int k=1; k<=maxHeight; k++) {
            visited = new int[n][m]; //매번 갱신
            int result = countSafeArea(k);
            if (maxSafeArea < result) {
                maxSafeArea = result;
                heightOfMaxSafeArea = k;
            }
        }

        System.out.println(heightOfMaxSafeArea + " " + maxSafeArea);
    }

    public static int countSafeArea(int height) {
        int cnt = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (houses[i][j] > height && visited[i][j] == 0) {
                    cnt++;
                    dfs(i, j, height);
                }
            }
        }

        return cnt;
    }

    public static void dfs(int x, int y, int height) {
        visited[x][y] = 1;

        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (inRange(nx, ny) && houses[nx][ny] > height && visited[nx][ny] == 0) {
                dfs(nx, ny, height);
            }
        }
    }
}