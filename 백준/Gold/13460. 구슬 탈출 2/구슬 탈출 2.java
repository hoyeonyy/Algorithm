import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int red_x, red_y, blue_x, blue_y;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 'R') {
                    red_x = i;
                    red_y = j;
                }
                else if(map[i][j] == 'B') {
                    blue_x = i;
                    blue_y = j;
                }
            }
        }

        System.out.println(bfs(red_x, red_y, blue_x, blue_y));
    }

    private static int bfs(int red_x, int red_y, int blue_x, int blue_y) {

        Queue<location> q = new LinkedList<>();
        int time = 1;

        q.add(new location(red_x, red_y, blue_x, blue_y));

        xyd move_red , move_blue;
        while(!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                location now = q.poll();

                for (int d = 0; d < 4; d++) {
                    move_red = move(now.red_x, now.red_y, 0, d);
                    move_blue = move(now.blue_x, now.blue_y, 0, d);

                    if(map[move_blue.r][move_blue.c] == 'O') continue;
                    if(map[move_red.r][move_red.c] == 'O') return time;

                    if (move_red.r == move_blue.r && move_red.c == move_blue.c) {
                        if(move_red.dist> move_blue.dist) {
                            move_red.r -= dx[d];
                            move_red.c -= dy[d];
                        } else {
                            move_blue.r -= dx[d];
                            move_blue.c -= dy[d];
                        }
                    }



                    q.add(new location(move_red.r, move_red.c, move_blue.r, move_blue.c));
                }
            }

            if(++time > 10) return -1;
        }
        return -1;
    }

    private static xyd move(int x, int y, int dist, int d) {

        int temp_x = x, temp_y = y;
        while(map[temp_x + dx[d]][temp_y + dy[d]] != '#' && map[temp_x][temp_y] != 'O') {
            temp_x += dx[d];
            temp_y += dy[d];
            dist++;
        }

        return new xyd(temp_x, temp_y, dist);
    }

    static class xyd {
        int r, c, dist;

        public xyd(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

    }

    static class location {
        int red_x, red_y, blue_x, blue_y;

        public location(int red_x, int red_y, int blue_x, int blue_y) {
            this.red_x = red_x;
            this.red_y = red_y;
            this.blue_x = blue_x;
            this.blue_y = blue_y;
        }
    }
}