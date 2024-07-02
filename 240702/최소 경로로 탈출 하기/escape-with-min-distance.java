import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int n, m;
    public static int[][] grid, visited, dist;
    public static Queue<int[]> queue = new LinkedList<>();

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new int[n][m];
        dist = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        queue.add(new int[] {0, 0});
        int result = escape();

        System.out.println(result);
    }

    public static int escape() {
        while (!queue.isEmpty()) {
            int[] currIdx = queue.poll();
            int x = currIdx[0];
            int y = currIdx[1];

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (inRange(nx, ny) && visited[nx][ny] == 0 && grid[nx][ny] == 1) {
                    if (nx == n-1 && ny == m-1) {
                        return dist[x][y] + 1;
                    }
                    visited[nx][ny] = 1;
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        return -1;
        
    }
}