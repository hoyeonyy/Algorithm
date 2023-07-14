import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//    public ArrayList<Integer> solution(int n, int[] a, int m, int[] b) {
//
//
//
//
//
//        return answer;
//
//    }

    public static void main(String[] args) {
        Main T = new Main();

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] a= new int[100][100];
        for (int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            for (int j = x; j < x+10; j++) {
                for (int k = y; k < y+10; k++) {
                    a[j][k] = 1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(a[i][j] == 1)sum += 1;
            }
        }

        System.out.println(sum);



    }
}