import java.util.Scanner;

public class Main {
    public static int x, y, n;
    public static int[][] grid;
    public static boolean canMove;
    public static int[] dx = {-1, 1, 0, 0};//NSWE
    public static int[] dy = {0, 0, -1, 1};

    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int r = sc.nextInt() - 1; //0~n-1로 범위 맞춰줌
        int c = sc.nextInt() - 1;

        grid = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        canMove = true;
        x = r;
        y = c;

        int[] visited = new int[100];
        int endOfVisited = 0;
        while (canMove) {
            visited[endOfVisited++] = grid[x][y];
            int[] result = move(x, y);
            if (result[0] != -1 && result[1] != -1) {
                x = result[0];
                y = result[1];
            } else {
                canMove = false;
            }
        }

        for (int elem: visited) {
            if (elem != 0) {
                System.out.print(elem + " ");
            } else {
                break;
            }
        }
    }

    public static int[] move(int x, int y) {
        int maxValue = grid[x][y];
        int[] moveTo = {-1, -1};

        for (int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (inRange(nx, ny) && maxValue < grid[nx][ny]) {
                moveTo[0] = nx;
                moveTo[1] = ny;
                break;
            }
        }
        return moveTo;
    }
}