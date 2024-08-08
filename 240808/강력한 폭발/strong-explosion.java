import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static int n, bombCnt, maxCnt;
    public static int[][] visited;
    public static List<int[]> bombPoints = new ArrayList<>();
    public static int[] dxBomb1 = new int[] {-2, -1, 0, 1, 2};
    public static int[] dyBomb1 = new int[] {0, 0, 0, 0, 0};
    public static int[] dxBomb2 = new int[] {-1, 0, 0, 0, 1};
    public static int[] dyBomb2 = new int[] {0, -1, 0, 1, 0};
    public static int[] dxBomb3 = new int[] {-1, -1, 0, 1, 1};
    public static int[] dyBomb3 = new int[] {-1, 1, 0, -1, 1};
    public static boolean inRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }
    public static int[][] deepCopy(int[][] original) { //2차원 배열 복사
        int[][] copy = new int[n][n];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visited = new int[n][n];

        bombCnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (sc.nextInt() == 1) {
                    bombCnt++;
                    bombPoints.add(new int[]{i, j});
                }
            }
        }

        // System.out.println("bombCnt = " + bombCnt);
        // for (int[] arr: bombPoints) {
        //     System.out.println(arr[0] + ", " + arr[1]);
        // }

        maxCnt = -1;
        int pointX = bombPoints.get(0)[0];
        int pointY = bombPoints.get(0)[1];
        for (int b=1; b<=3; b++) {
            countDestroyedAreas(pointX, pointY, 0, b, 0);
            visited = new int[n][n]; //매번 초기화
        }

        System.out.println(maxCnt);
    }

    public static void countDestroyedAreas(int x, int y, int depth, int bomb, int prevCnt) {
        int expectCnt = prevCnt + (bombCnt - depth) * 5; //기대 최대값이 지금까지 얻은 최대값보다 작을때 backtrack
        if (maxCnt > expectCnt) {
            return;
        }

        int currCnt = realCount(x, y, prevCnt, bomb); //현재 폭탄까지 해서 초토화된 영역 합산 

        if (depth >= bombCnt - 1) { //바닥조건, backtrack
            maxCnt = Math.max(currCnt, maxCnt);

            //debug
            // System.out.println("bomb = " + bomb + ", currCnt = " + currCnt + ", maxCnt = " + maxCnt);
            // for (int[] arr: visited) {
            //     for (int elem: arr) {
            //         System.out.print(elem + " ");
            //     }
            //     System.out.println();
            // }
            return;
        }

        int nextPointX = bombPoints.get(depth+1)[0];
        int nextPointY = bombPoints.get(depth+1)[1];
        for (int b=1; b<=3; b++) {
            int[][] prevVisited = deepCopy(visited); //해결 : prevVisited를 전역이 아닌 지역변수로 사용!!!!
            //debug
            // System.out.println("prevvisited!!!!!!" + ": depth = " + depth + ", bomb = " + bomb);
            // for (int[] arr: prevVisited) {
            //     for (int elem: arr) {
            //         System.out.print(elem + " ");
            //     }
            //     System.out.println();
            // }

            countDestroyedAreas(nextPointX, nextPointY, depth+1, b, currCnt); //visited를 가지고 dfs돎
        
            visited = deepCopy(prevVisited); //이전버전 visited를 복사
            // System.out.println("visited!!!!!!");
            // for (int[] arr: visited) {
            //     for (int elem: arr) {
            //         System.out.print(elem + " ");
            //     }
            //     System.out.println();
            // }
        }
        
    }

    public static int realCount(int x, int y, int prevCnt, int bomb) {
        // int currCnt = prevCnt;
        if (bomb == 1) {
            for (int d=0; d<5; d++) {
                int nx = x + dxBomb1[d];
                int ny = y + dyBomb1[d];
                if (inRange(nx, ny) && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    prevCnt++;
                }
            }
        } else if (bomb == 2) {
            for (int d=0; d<5; d++) {
                int nx = x + dxBomb2[d];
                int ny = y + dyBomb2[d];
                if (inRange(nx, ny) && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    prevCnt++;
                }
            }
        } else if (bomb == 3) {
            for (int d=0; d<5; d++) {
                int nx = x + dxBomb3[d];
                int ny = y + dyBomb3[d];
                if (inRange(nx, ny) && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    prevCnt++;
                }
            }
        }
        return prevCnt;
    }
}