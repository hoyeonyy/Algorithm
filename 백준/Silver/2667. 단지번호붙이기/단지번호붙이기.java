import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n;
    static int cnt;
    static int[][] board;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int j = 0;
            for (char c : str.toCharArray()) {
                board[i][j] = c - '0';
                j++;
            }
        }



        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 1) {
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
            sb.append(i).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        board[x][y] = 0;

        for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(0<=nx && nx<n && 0<=ny && ny < n) {
                if(board[nx][ny] == 1) {
                    dfs(nx,ny);
                }
            }
        }
        cnt++;

    }

}