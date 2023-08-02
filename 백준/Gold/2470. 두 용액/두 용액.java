import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

//    public ArrayList<Xy> solution(int n, ArrayList<Xy> arr) {
//
//
//    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt = n-1;
        int max = Integer.MAX_VALUE;
        int r_lt = 0 , r_rt = 0;
        while (lt < rt){
            int sum = arr[lt] + arr[rt];
            int abs = Math.abs(sum);
            if(abs < max){
                max = abs;
                r_lt = lt;
                r_rt = rt;
            }
            if(sum > 0){
                rt--;
            }
            else{
                lt++;
            }
        }

        System.out.println(arr[r_lt] + " "+ arr[r_rt]);

    }



}
