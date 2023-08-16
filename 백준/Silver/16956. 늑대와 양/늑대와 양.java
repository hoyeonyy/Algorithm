import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int r, c;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            int j = 0;
            for (char c1 : tmp.toCharArray()) {
                map[i][j] = c1;
                j++;
            }
        }
        boolean flag = true;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(map[i][j] == 'W') {
                    for(int k = 0 ; k<4; k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];

                        if(nx >=0 && nx< r && ny >=0 && ny<c) {
                            if(map[nx][ny]=='.') {
                                map[nx][ny]='D';
                            }else if(map[nx][ny]=='S') {
                                flag = false;
                                System.out.println(0);
                                return;
                            }
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(flag == true){
            System.out.println("1");
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(map[i][j]);
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);

    }
//    static void DFS(int a, int cnt){
//
//
//
//
//
//    }

}