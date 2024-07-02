import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public static int n;
    public static int[][] grid;
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
        int m = sc.nextInt();

        grid = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        queue.add(new int[] {0, 0});
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

                if (inRange(nx, ny) && grid[nx][ny] == 1) {
                    if (nx == n-1 && ny == n-1) {
                        return true;
                    }
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        return false;
    }
}