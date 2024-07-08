import java.util.Scanner;

public class Main {
    public static int n, m, k;
    public static int maxScore = -1;
    public static int[] position, distances;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        distances = new int[n];
        position = new int[k];

        for (int i=0; i<n; i++) {
            distances[i] = sc.nextInt();
        }
        for (int i=0; i<k; i++) {
            position[i] = 1;
        }

        play(0, 0);
        System.out.println(maxScore);

    }

    public static void play(int depth, int score) {
        if (depth > n-1) {
            if (score > maxScore) {
                // System.out.println("depth=" + depth + " score=" + score);
                maxScore = score;
            }
            return;
        }

        int dist = distances[depth];

        for (int i=0; i<k; i++) {
            if (position[i] >= m) {
                play(depth+1, score);
            } else if (position[i] + dist >= m) {//목적지에 도달
                position[i] += dist;
                play(depth+1, score+1);
                position[i] -= dist;
            } else {
                position[i] += dist;
                play(depth+1, score);
                position[i] -= dist;
            }
        }
    }
}