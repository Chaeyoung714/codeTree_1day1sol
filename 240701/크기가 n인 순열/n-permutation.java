import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] arr, visited;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        visited = new int[n];

        choose(0);

    }

    public static void choose(int depth) {
        if (depth > n - 1) {
            for (int elem: arr) {
                System.out.print(elem + " ");
            }
            System.out.println();
            // visited = new int[n]; //리프까지 갈때마다 visited 갱신
            return;
        }

        for (int val=1; val<=n; val++) {
            if (visited[val-1] == 0) { //방문한적없는 값
                arr[depth] = val;
                visited[val-1] = 1;

                choose(depth+1);

                //백트래킹 해서 실행하는 위치 : 무조건 리프노드를 찍고 올라오는 상태
                visited[val-1] = 0;
            } else {
                continue;
            }
        }
    }
}