import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public ArrayList<Integer> solution(int n, int m , int[] arr) {

        ArrayList<Integer> answer = new ArrayList<>();

        int max, sum = 0;
        int cnt = 0;
        int lt = 0 , rt = lt + m;
        for (int i = 0; i < rt; i++) {
            sum = sum + arr[i];
        }
        max = sum;
        for ( ; rt < n; rt++) {
            sum = sum + arr[rt];
            sum = sum - arr[lt];
            lt++;
            if(max < sum){
                max = sum;
            }
        }

        answer.add(max);
        sum = 0;
        lt = 0;
        rt = lt+m;
        for (int i = 0; i < rt; i++) {
            sum = sum + arr[i];
        }
        if(sum == max)cnt++;
        for ( ; rt < n; rt++) {
            sum = sum + arr[rt];
            sum = sum - arr[lt];
            lt++;
            if(max == sum){
                cnt++;
            }
        }
        answer.add(cnt);
        return answer;
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
        for (int i : T.solution(n, m, arr)) {
            if(i == 0) {
                System.out.println("SAD");
                break;
            }
            else System.out.println(i);
        }

    }
}