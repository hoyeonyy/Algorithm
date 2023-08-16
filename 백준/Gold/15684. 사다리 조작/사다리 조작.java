import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] ladder;
    static int n, m, h;
    static int answer = 4;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        ladder = new int[h+4][n+4];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = 1;
            ladder[a][b+1] = 2;
        }
        DFS(1, 0);
        if(answer >= 4) System.out.println(-1);
        else System.out.println(answer);

    }
    static void DFS(int a, int cnt){

        if(answer <= cnt)return;
        if(isGood()){
            answer = cnt;
            return;
        }
        else{
            for (int i = a; i <= h; i++) {
                for (int j = 1; j < n; j++) {
                    if(ladder[i][j] ==0 && ladder[i][j+1] == 0){
                        ladder[i][j] = 1;
                        ladder[i][j+1] = 2;
                        DFS(i, cnt+1);
                        ladder[i][j] = 0;
                        ladder[i][j+1] = 0;
                    }
                }
            }
        }



    }
    static boolean isGood(){

        for (int i = 1; i <= n; i++) {

            int x = 1, y = i;
            for (int j = 1; j <= h; j++) {
                if (ladder[x][y] == 1) y++;
                else if (ladder[x][y] == 2) y--;
                x++;
            }
            if (y != i) return false;
        }
        return true;

    }
}