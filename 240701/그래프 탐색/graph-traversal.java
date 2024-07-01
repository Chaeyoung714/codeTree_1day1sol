import java.util.Scanner;

public class Main {
    public static int[][] graph, visited;
    public static int n, fromIdx, toIdx;
    public static int cnt = 0;
    public static boolean satisfied;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        graph = new int[n+1][n+1]; //0번인덱스는 쓰지 않음
        visited = new int[n+1][n+1];

        for (int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x == 1) { //시작점은 이미 visited 처리
                visited[y][x] = 1;
            } else if (y == 1) {
                visited[x][y] = 1;
            }

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(1);
        // for (int i = 1; i<=n; i++) { //1번정점에서 시작 
        //     if (graph[1][i] == 1) {
        //         fromIdx = 1;
        //         toIdx = i;
        //         dfs(toIdx);
        //     }
        // }

        System.out.println(cnt);
    }

    public static void dfs(int currIdx) {
        // if (currIdx == 1 && visited[fromIdx][currIdx] == 1) { //시작점에 재방문시
        //     return;
        // }
        satisfied = false;

        for (int i=1; i<=n; i++) {
            if (graph[currIdx][i] == 1 && visited[currIdx][i] == 0) {
                satisfied = true; //현위치에서 진행할 점 있음

                cnt++; //정점 수
                fromIdx = currIdx;
                toIdx = i;
                
                for (int j=1; j<=n; j++) {
                    if (graph[j][toIdx] == 1) {
                        visited[j][toIdx] = 1;
                    }
                }
                // visited[fromIdx][toIdx] = 1;

                // for (int[] arr: visited) {
                //     for (int v: arr) {
                //         System.out.print(v + " ");
                //     }
                //     System.out.println();
                // }
                // System.out.println("nextnextnextnextnxet");

                dfs(toIdx);
            }
        }

        if (!satisfied) { //현위치에서 더이상 진행할 점 없다면
            return;
        }
    }
}