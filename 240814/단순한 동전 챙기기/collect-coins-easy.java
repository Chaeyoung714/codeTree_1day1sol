import java.util.Scanner;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static int MAX_VALUE = Integer.MAX_VALUE;
    public static int minMoveCnt = MAX_VALUE;
    public static int n, coinCnt, pointsListSize;
    public static int[][] moveDists;
    public static List<Point> points = new ArrayList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
    public static class Point {
        private int x;
        private int y;
        private int value;

        public Point(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y= y;
        }
        public int getValue() { return value; }
        public int getX() { return x; }
        public int getY() { return y; }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        coinCnt = 0;

        for (int i=0; i<n; i++) {
            String inputString = sc.next(); //공백없이 받아짐 

            for (int j=0; j<n; j++) {
                String input = Character.toString(inputString.charAt(j));

                if (input.equals(".")) {
                    continue;
                } else if (input.equals("S")) {
                    points.add(new Main.Point(-1, i, j));
                } else if (input.equals("E")) {
                    points.add(new Main.Point(MAX_VALUE, i, j));
                } else {
                    int coin = Integer.parseInt(input);
                    points.add(new Main.Point(coin, i, j));
                    coinCnt++;
                }
            }
        }
        points.sort((point1, point2) -> point1.getValue() > point2.getValue() ? 1 : -1); //오름차순 정렬       
        //points = {Point<S>, Point<1>, Point<2>, Point<4>, Point<5>, Point<E>}
        pointsListSize = points.size();

        // System.out.println("points");
        // for (Point point: points) {
        //     System.out.print(point.getValue() + ", ");
        // }
        // System.out.println();

        if (coinCnt < 3) {
            minMoveCnt = -1;
        } else {
            fillMoveDists();

            // System.out.println("moveDists");
            // for (int[] arr: moveDists) {
            //     for (int elem: arr) {
            //         System.out.print(elem + " ");
            //     }
            //     System.out.println();
            // }

            findMinMoveCnt(0, 0, 0);
        }
        System.out.println(minMoveCnt);
    }

    public static void fillMoveDists() {
        moveDists = new int[pointsListSize][pointsListSize];

        for (int i=0; i<pointsListSize; i++) {
            for (int j=0; j<pointsListSize; j++) {
                if (i >= j) { //예외 - 더 큰 숫자로의 이동만 가능함 
                    moveDists[i][j] = -1;
                    continue;
                }
                int startX = points.get(i).getX();
                int startY = points.get(i).getY();
                int arriveX = points.get(j).getX();
                int arriveY = points.get(j).getY();
                int cnt = 0;

                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{startX, startY, cnt});

                //BFS로 start -> arrive까지의 최소경로 구하기
                boolean arrived = false;
                while (!arrived) {
                    int[] pointInfo = queue.remove(); //없으면 에러 반환
                    int x = pointInfo[0];
                    int y = pointInfo[1];
                    cnt = pointInfo[2];

                    for (int d=0; d<4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (inRange(nx, ny)) {
                            if (nx == arriveX && ny == arriveY) {
                                arrived = true;
                                cnt++;
                                break;
                            }
                            queue.add(new int[]{nx, ny, cnt+1});
                        }
                    }
                }

                moveDists[i][j] = cnt;

            }
        }
    }

    public static void findMinMoveCnt(int from, int depth, int moveCnt) {
        if (depth == 3) { //바닥조건
            moveCnt += moveDists[from][pointsListSize-1]; //from -> end로
            minMoveCnt = Math.min(moveCnt, minMoveCnt);
            // System.out.println(", from = " + from + ", minCnt = " + minMoveCnt);
            return;
        }
        if (from == pointsListSize - 2 && depth < 3) { //depth=3이 되기 전에 최대 숫자를 방문했다면 -> 중단
            // System.out.println();
            return;
        }

        // System.out.print(", from = " + from);

        for (int to=from+1; to<pointsListSize-1; to++) {
            moveCnt += moveDists[from][to]; //from -> to로
            findMinMoveCnt(to, depth+1, moveCnt);
        }
    }
}