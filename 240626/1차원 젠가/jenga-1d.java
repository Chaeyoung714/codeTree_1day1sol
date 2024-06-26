import java.util.Scanner;

public class Main {

    public static int[] blocks;
    public static int n;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        blocks = new int[n];

        for (int i=0; i<n; i++) {
            blocks[i] = sc.nextInt();
        }

        int blockLength = 0;
        for (int i=0; i<2; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            blockLength = doZenga(start, end);
        }
        
        System.out.println(blockLength);
        for (int elem: blocks) {
            if (elem != 0) {
                System.out.println(elem);
            }
        }

    }

    public static int doZenga(int start, int end) {
        int[] tempArr = new int[n];

        int j = 0;
        for (int i=0; i<n; i++) {
            if (i>=start-1 && i <=end-1) {
                continue;
            } else {
                tempArr[j] = blocks[i];
                j++;
            }
        }
        
        int blockLength = 0;
        for (int i=0; i<n; i++) {
            if (tempArr[i] != 0) {
                blocks[i] = tempArr[i];
                blockLength ++;
            } else {
                blocks[i] = 0;
            }
        }

        return blockLength;
    }
}