import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int n, m;
    public static int maxResult = -1;
    public static int[] nums;
    public static ArrayList<Integer> resultList = new ArrayList<>();

    // public static String XOR(String x, String y) {
    //     String[] xArray = x.split("");
    //     String[] yArray = y.split("");
    //     String[] zArray = new String[m];
    //     // for (String elem: xArray) {
    //     //     System.out.println(elem + " ");
    //     // }
    //     // for (int i=0; i<m; i++) {
    //     //     if (xArray[i] == yArray[i]) {
    //     //         zArray[i] = "0";
    //     //     } else {
    //     //         zArray[i] = "1";
    //     //     }
    //     // }
    //     String z = String.join("", zArray);
    //     // int finalZ = Integer.parseInt(z, 2);
    //     return z;
    // }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        nums = new int[n];

        for (int i=0; i<n; i++) {
            // nums[i] = Integer.toBinaryString(sc.nextInt());
            nums[i] = sc.nextInt();
        }


        if (m == 1) {
            for (int elem:nums) {
                maxResult = Math.max(maxResult, elem);
            }
        } else {
            findMax(0);
        }

        System.out.println(maxResult);

    }

    public static void findMax(int depth) {
        if (depth > m - 1) {
            int result = 0;
            for (int j=0; j<m-1; j++) {
                if (j == 0) {
                    result = resultList.get(j) ^ resultList.get(j+1);
                } else {
                    result = result ^ resultList.get(j+1);
                }
            } 

            // System.out.println("result=" + result);

            // int resultInt = Integer.parseInt(result, 2);
            if (result > maxResult) {
                maxResult = result;
            }
            return;
        }

        for (int i=0; i<n; i++) {
            if (resultList.contains(nums[i])) {
                continue;
            }
            resultList.add(nums[i]);
            findMax(depth+1);
            resultList.remove(resultList.size()-1);
        }


    }
}