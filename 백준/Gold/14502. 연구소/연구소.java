import java.io.*;
import java.util.*;

public class Main {

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int board[][];
    static int n,m;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(max);
    }

    static void dfs(int l) {
        if(l == 3) {
            bfs();
            return;
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                    dfs(l+1);
                    board[i][j] = 0;
                }
            }
        }
    }
    static void bfs() {
        Queue<XY> queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 2) {
                    queue.add(new XY(i,j));
                }
            }
        }
        int tmp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            tmp[i] = board[i].clone();
        }
        while(!queue.isEmpty()) {
            XY now = queue.poll();
            int x = now.x;
            int y = now.y;
            for(int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(0<=nx && nx<n && 0<=ny && ny<m) {
                    if(tmp[nx][ny] == 0) {
                        queue.add(new XY(nx,ny));
                        tmp[nx][ny] = 2;
                    }
                }
            }
        }
        isGood(tmp);
    }

    private static void isGood(int[][] CopyBoard) {
        int cnt =0;
        for(int i=0; i<n ; i++) {
            for(int j=0; j<m; j++) {
                if(CopyBoard[i][j] == 0) {
                    cnt++;
                }
            }
        }
        if (max < cnt) {
            max = cnt;
        }
    }
    static class XY {
        int x;
        int y;
        XY(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}