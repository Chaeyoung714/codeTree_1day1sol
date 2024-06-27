import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] grid, countArr, moveArr;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static boolean inRange(int x, int y) {
        return (x>=0 && x<n && y>=0 && y<n);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();

        grid = new int[n][n];
        countArr = new int[n][n];
        moveArr = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        //count 초기화
        for (int i=0; i<m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            countArr[r][c]++;
        }

        for (int i=0; i<t; i++) {
            move();

            for (int x=0; x<n; x++) {
                for (int y=0; y<n; y++) {
                    if (countArr[x][y] > 1) {
                        countArr[x][y] = 0;
                    }
                }
            }
        }

        int totalCnt = 0;
        for (int x=0; x<n; x++) {
            for (int y=0; y<n; y++) {
                if (countArr[x][y] == 1) {
                    totalCnt ++;
                } else if (countArr[x][y] > 1){
                    System.out.println("error: " + x + y);
                }
            }
        }

        System.out.println(totalCnt);
    }

    public static void move() {
        moveArr = new int[n][n]; //매번 초기화

        for (int x=0; x<n; x++) {
            for (int y=0; y<n; y++) {
                if (countArr[x][y] != 0) {
                    int maxVal = 0;
                    int maxX = -1;
                    int maxY = -1;

                    for (int d=0; d<4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (inRange(nx, ny) && grid[nx][ny] > maxVal) { //==maxVal은 고려하지 않아도 됨
                            maxVal = grid[nx][ny];
                            maxX = nx;
                            maxY = ny;
                        }
                    }
                    //move배열에 기록
                    moveArr[maxX][maxY]++;
                } else {
                    continue;
                }


            }
        }

        countArr = moveArr;
    }
}