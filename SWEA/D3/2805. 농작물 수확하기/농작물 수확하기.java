import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    static int n;
    static int [][] ar;
    static int[][] checked;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int cnt;
    static int answer;
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            n = Integer.parseInt(br.readLine());
            answer = 0;
            ar = new int[n][n];
            checked = new int[n][n];
            for (int j = 0; j < n; j++) {
                char[] chars = br.readLine().toCharArray();
                for (int k = 0; k < n; k++) {
                    ar[j][k] = Character.getNumericValue(chars[k]);
                }
            }
            cnt = n/2;
            checked[n/2][n/2] = 1;
            answer += ar[n/2][n/2];
            bfs(n / 2, n / 2);
            System.out.println("#" + (i+1) +" " + answer);
        }
    }
    static void bfs(int x, int y){
        Queue<Xy> queue = new LinkedList<>();
        queue.offer(new Xy(x, y));
        int a = 0;
        while (a < cnt){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Xy tmp = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx >=0 && ny >=0 && nx < n && ny<n&&checked[nx][ny] == 0){
                        checked[nx][ny] = 1;
                        answer += ar[nx][ny];
                        queue.offer(new Xy(nx, ny));
                    }
                }
            }
            a++;
        }


    }
    static class Xy{
        int x;
        int y;

        public Xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}