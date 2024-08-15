import java.util.Scanner;

public class Main {
    public static int n, minCost;
    public static int[][] costs;
    public static int[] visited;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        costs = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                costs[i][j] = sc.nextInt();
            }
        } 

        minCost = Integer.MAX_VALUE;
        visited = new int[n];
        visited[0] = 1;
        findMinCost(0, 0, 0); //0~n-1번 지점

        System.out.println(minCost);
    }

    public static void findMinCost(int from, int cost, int depth) {
        if (depth >= n-1) { //n-1번 이동 후
            if (costs[from][0] != 0) {
                cost += costs[from][0];
                minCost = Math.min(minCost, cost);
            }
            return;
        }

        for (int to=0; to<n; to++) {
            if (visited[to] == 0 && costs[from][to] != 0) {
                visited[to] = 1;
                findMinCost(to, cost + costs[from][to], depth+1);
                visited[to] = 0;
            }
        }
    }
}