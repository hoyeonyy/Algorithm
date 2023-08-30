import java.io.*;
import java.util.*;


class Main {
    static ArrayList<String> answer = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static String[][] map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new String[5][5];

        for(int i=0;i<5;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++) {
                map[i][j] = st.nextToken();
            }
        }
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                dfs(i, j, 0, map[i][j]);
            }
        }
        System.out.println(answer.size());
    }

    public static void dfs(int x, int y, int cnt, String str) {
        if(cnt == 5) {
            if(!answer.contains(str)) {
                answer.add(str);
            }
            return;
        }
        for(int i=0;i<4;i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if((0<=nx&&nx<5)&&(0<=ny&&ny<5)) {
                dfs(nx, ny, cnt+1, str+map[nx][ny]);
            }
        }
    }
}