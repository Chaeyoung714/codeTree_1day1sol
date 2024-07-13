import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

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

        Arrays.sort(nums);


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
            int result = -1;
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
        
        int currVal = -1;
        if (depth == 0) {
            currVal = 0;
        } else {
            currVal = resultList.get(resultList.size()-1);
        }

        for (int i=currVal; i<n; i++) {
            if (nums[i] <= currVal) {
                continue;
            }
            resultList.add(nums[i]); //지금까지 선택된 값들보다 큰 값에 대해서만 진행 - 중복 방지 위해
            findMax(depth+1);
            resultList.remove(resultList.size()-1);
        }


    }
}