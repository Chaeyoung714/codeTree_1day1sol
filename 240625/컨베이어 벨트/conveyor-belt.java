import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] upperNums = new int[n];
        int[] lowerNums = new int[n];
        for (int i=0; i<2*n; i++) {
            if (i < n) {
                upperNums[i] = sc.nextInt();
            }
            else {
                lowerNums[i-n] = sc.nextInt();
            }
        }

        for (int i=0; i<t; i++) {
            int upperTemp = changePosition(upperNums);
            int lowerTemp = changePosition(lowerNums);

            upperNums[0] = lowerTemp;
            lowerNums[0] = upperTemp;
        }

        for (int elem: upperNums) {
            System.out.print(elem + " ");
        }
        System.out.println("");
        for (int elem: lowerNums) {
            System.out.print(elem + " ");
        }
    }

    public static int changePosition(int[] arr) {
        int n = arr.length;
        int temp = arr[n-1];

        for (int i=n-1; i>0; i--) {
            arr[i] = arr[i-1];
        }

        return temp;
    }
}