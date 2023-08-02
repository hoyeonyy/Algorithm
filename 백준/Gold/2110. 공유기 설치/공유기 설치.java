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
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 1, rt = arr[n-1];
        int answer = 0;
        while (lt<=rt){
            int mid = (lt+rt)/2;

            if(count(arr, mid) >= m){
                lt = mid + 1;
                answer = mid;
            }
            else{
                rt = mid -1;
            }
        }
        System.out.println(answer);
    }

    public static int count(int[] arr, int dist){
        int cnt = 1;

        int ep = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] - ep >= dist){
                cnt++;
                ep = arr[i];
            }
        }


        return cnt;
    }

}
