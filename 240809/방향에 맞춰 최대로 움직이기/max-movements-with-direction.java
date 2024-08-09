import java.util.Scanner;

public class Main {
    public static int n, maxCnt;
    public static int[][] numArray, dirArray;
    public static int[] dx = {-10, -1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {-10, 0, 1, 1, 1, 0, -1, -1, -1};
    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        numArray = new int[n][n];
        dirArray = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                numArray[i][j] = sc.nextInt();
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                dirArray[i][j] = sc.nextInt();
            }
        }

        int startX = sc.nextInt() - 1; //인덱스 0부터 사용
        int startY = sc.nextInt() - 1;

        maxCnt = -1;
        countMove(startX, startY, 0); //해당 위치에서 움직일 수 있는 모든 횟수 중 최대횟수를 구함 

        if (maxCnt == -1) {
            System.out.println(0);
        } else {
            System.out.println(maxCnt);
        }
    }

    public static void countMove(int x, int y, int cnt) {
        boolean canMove = true;
        // System.out.println("x = " + x + ", y = " + y + ", cnt = " + cnt + canMove);

        int dir = dirArray[x][y];
        for (int i = 1; i < n; i++) { //최소 1, 최대 n-1번 이동함
            if (canMove == false) { //바닥조건 - 볼수있는 case가 하나밖에 없으므로 이렇게 설정되네.
                // System.out.println("!!!x = " + x + ", y = " + y + ", cnt = " + cnt + canMove + ", " + i);

                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    return;
                }
            }

            int nx = x + (dx[dir] * i);
            int ny = y + (dy[dir] * i);

            if (inRange(nx, ny)) {
                if (numArray[nx][ny] > numArray[x][y]) { //두 조건을 한번에 뭉치면 1트에서 실패하면 그뒤로는 진행을 못함
                    countMove(nx, ny, cnt+1);
                }
            } else {
                canMove = false;
            }
        }
    }
}