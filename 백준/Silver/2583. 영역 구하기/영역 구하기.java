import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n;
    static int m;
    static int cnt;
    static int[][] board;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y=y1; y<y2; y++) {
                for(int x=x1; x<x2; x++){
                    board[y][x] = 1;
                }
            }
        }
        
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 0) {
                    cnt = 0;
                    dfs(i,j);
                    result.add(cnt);
                }
            }
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');
        for(int i : result)  {
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        board[x][y] = 1;

        for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(0<=nx && nx<n && 0<=ny && ny < m) {
                if(board[nx][ny] == 0) {
                    dfs(nx,ny);
                }
            }
        }
        cnt++;

    }

}