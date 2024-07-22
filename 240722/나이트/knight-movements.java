import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int n;
    public static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[][] grid = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[n][n];

        int r1 = sc.nextInt() - 1;
        int c1 = sc.nextInt() - 1;
        int r2 = sc.nextInt() - 1;
        int c2 = sc.nextInt() - 1;

        int depth = 0;
        queue.add(new int[] {r1, c1, depth});

        boolean satisfied = false;
        int result = -1;
        while (!queue.isEmpty()) {
            int[] target = queue.poll();
            int x = target[0];
            int y = target[1];
            depth = target[2];
            visited[x][y] = 1;

            // System.out.println(x + ", " + y + ", " + depth);

            if (x == r2 & y == c2) {
                // satisfied = true;
                result = depth;
                break; //BFS이므로 찾자마자 종료.
            }

            depth++; //하나 더 아래 depth 탐색

            for (int d=0; d<8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (inRange(nx, ny) && visited[nx][ny] == 0) { //방문한 곳은 dfs하지 않음
                    queue.add(new int[] {nx, ny, depth});
                }
            }
        }

        System.out.println(result);

    }
}