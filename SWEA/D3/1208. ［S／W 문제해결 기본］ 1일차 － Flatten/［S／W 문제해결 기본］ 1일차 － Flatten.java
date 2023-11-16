import java.io.*;
import java.util.*;

public class Solution {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            int[] arr = new int[100];
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < n; j++) {
                Arrays.sort(arr);
                if(arr[0] == arr[99])break;
                arr[0] += 1;
                arr[99] -= 1;
            }
            Arrays.sort(arr);
            System.out.println("#" + (i+1)+" " + (arr[99] - arr[0]));


        }



    }
}