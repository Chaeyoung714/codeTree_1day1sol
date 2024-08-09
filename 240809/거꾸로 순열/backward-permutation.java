import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
//간단하지만 가장 기본에 충실한 문제.

public class Main {
    public static int n;
    public static List<Integer> nums = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        dfs(n, 0);
    }

    public static void dfs(int me, int depth) {
        if (depth >= n) { //바닥조건
            for (int elem: nums) {
                System.out.print(elem + " ");
            }
            System.out.println();
            return;
        }
        for (int i = n; i >= 1; i--) {
            if (nums.contains(i)) {
                continue;
            }
            nums.add(i);
            dfs(i, depth+1);
            nums.remove(nums.size()-1); //복원
        }
    }
}