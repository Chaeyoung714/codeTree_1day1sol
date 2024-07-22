import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int n, k;
    public static int totalCnt = 0;
    public static Queue<int[]> queue = new LinkedList<>();
    public static int[][] grid, visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        visited = new int[n][n]; //0으로 초기화
        // int[][] starts = new int[k][2];
        

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<k; i++) {
            int r = sc.nextInt() - 1; //0부터 시작
            int c = sc.nextInt() - 1; //0부터 시작

            queue.add(new int[] {r, c});
            if (visited[r][c] == 0) {
                visited[r][c] = 1;
                totalCnt++;
            }
            bfs();
        }

        System.out.println(totalCnt);
    }

    public static void bfs() {   

        while (!queue.isEmpty()) {
            int[] search = queue.poll();
            int x = search[0];
            int y = search[1];
            // System.out.println("poll = " + x + ", " + y);

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (inRange(nx, ny) && grid[nx][ny] == 0) {
                    if (visited[nx][ny] == 1) {
                        continue;
                    } else {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = 1;
                        totalCnt++;
                    }
                }
            }
        }
    }
}