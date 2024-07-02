import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public static int n, m;
    public static int[][] grid, visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static Queue<int[]> queue = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[m][n];
        visited = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        queue.add(new int[] {0, 0});
        visited[0][0] = 1;
        boolean result = escape();

        if (result) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    public static boolean escape() {
        while (!queue.isEmpty()) {
            int[] currIdx = queue.poll();
            int x = currIdx[0];
            int y = currIdx[1];

            for (int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (inRange(nx, ny) && visited[nx][ny] == 0 && grid[nx][ny] == 1) {
                    if (nx == m-1 && ny == n-1) {
                        return true;
                    }
                    visited[nx][ny] = 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        return false;
    }
}