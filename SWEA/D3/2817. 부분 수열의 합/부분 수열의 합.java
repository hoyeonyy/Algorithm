import java.util.*;
import java.io.*;
import java.awt.SystemTray;

class Solution {
    static int n;
    static int[] ar;
    static int goal;
    static int cnt;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tk = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= tk ; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            goal = Integer.parseInt(st.nextToken());
            ar = new int[n];
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);


            System.out.println("#" + testCase + " " + cnt);
        }
    }
    static void dfs(int sum, int i){
        if(sum == goal){
            cnt++;
            return;
        }
        if(i == n){
            return;
        }
        else{
            dfs(sum + ar[i], i+1);
            dfs(sum, i+1);
        }
    }
}