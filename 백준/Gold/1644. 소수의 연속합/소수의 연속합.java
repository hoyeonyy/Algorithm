import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public int solution(int n) {

        int answer = 0;
        ArrayList<Integer> prime = new ArrayList<>();
        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 2; i < Math.sqrt(n)+1 ; i++) {
            for (int j = i; j< n+1; j=j+i) {
                if(j != i)
                    arr[j] = 0;
            }
        }
        for (int i = 2; i < n+1; i++) {
            if(arr[i] != 0) prime.add(i);
        }

        int lt = 0, rt = 0;
        int sum = 0;
        for (rt = 0; rt < prime.size(); rt++) {
            sum += prime.get(rt);
            if(sum == n)answer++;
            while(sum > n){
                sum -= prime.get(lt);
                lt++;
                if(sum == n)answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Main T = new Main();

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(T.solution(n));

    }
}