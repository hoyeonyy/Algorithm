import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, l;
    static char[][][] buliding;
    static int[][][] checked;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0,- 1, 0, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int flag = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(l == 0 && n == 0 && m ==0)break;
            buliding = new char[l+4][n+4][m+4];
            checked = new int[l+4][n+4][m+4];
            int tmp_z = 1, tmp_y = 1, tmp_x = 1;
            for (int j = 1; j <= l; j++) {
                for (int k = 1; k <= n; k++) {
                    String tmp = br.readLine();
                    int o = 1;
                    for (char c : tmp.toCharArray()) {
                        if(c == 'S'){
                            tmp_z = j;
                            tmp_x = k;
                            tmp_y = o;
                        }
                        buliding[j][k][o] = c;
                        o++;
                    }

                }
                String tmp = br.readLine();
            }
            int level = bfs(tmp_z, tmp_x, tmp_y);
            if(flag == 1){
                System.out.println("Escaped in "+level+" minute(s).");
            }
            else{
                System.out.println("Trapped!");
            }
            flag = 0;
        }



    }
    static int bfs(int z, int x, int y) {
        int level = 0;
        Queue<Zxy> queue = new LinkedList<>();
        queue.offer(new Zxy(z, x, y));
        checked[z][x][y] = 1;
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Zxy tmp = queue.poll();
                for (int j = 0; j < 6; j++) {
                    int nz = tmp.z + dz[j];
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx >0 && nx <= n && ny > 0 && ny <=m && nz >0 && nz <=l && checked[nz][nx][ny] == 0){
                        checked[nz][nx][ny] = 1;
                        if(buliding[nz][nx][ny] == '.')
                            queue.offer(new Zxy(nz, nx, ny));
                        if(buliding[nz][nx][ny] == 'E'){
                            flag = 1;
                            return level+1;
                        }
                    }
                }
            }
            level++;
        }
        return level;
    }
    public static class Zxy{
        int x;
        int y;
        int z;

        public Zxy(int z, int x, int y) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}