import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public int solution(int n, int m , int[] arr) {

        int sum = 0, lt = 0, rt;
        int min = Integer.MAX_VALUE;

        for (rt = 0; rt < n; rt++) {
            sum = sum + arr[rt];

            while(sum >= m){
                if(min > rt - lt +1){
                    min = rt - lt +1;
                }
                sum = sum - arr[lt];
                lt++;
            }

        }
        if(min == Integer.MAX_VALUE)min = 0;
        return min;
    }


    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, m, arr));

    }
}