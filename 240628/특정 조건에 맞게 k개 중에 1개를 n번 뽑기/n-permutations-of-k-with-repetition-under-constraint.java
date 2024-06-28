import java.util.Scanner;

public class Main {
    public static int k, n;
    public static boolean isDuplicate = false;
    public static int[] arr;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        arr = new int[n];

        chooseConditional(0);
    }

    public static void chooseConditional(int depth) {
        if (depth > n-1) {
            for (int elem: arr) {
                System.out.print(elem + " ");
            }
            System.out.println();
            return;
        }

        for (int val=1; val<=k; val++) {
            if (depth > 1 && arr[depth-1] == val) {
                if (arr[depth-1] == arr[depth-2]) {
                    continue;
                }
            }
            arr[depth] = val;
            chooseConditional(depth+1);
        }
    }
}