import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] map;
    static boolean[][][][] checked; // 빨강, 파랑 구슬의 visit 상태
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int red_x, red_y, blue_x, blue_y;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // Row
        m = Integer.parseInt(st.nextToken()); // Column
        map = new char[n][m];
        checked = new boolean[n][m][n][m];

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

        Queue<Turn> q = new LinkedList<>();
        int time = 1;

        q.add(new Turn(red_x, red_y, blue_x, blue_y));
        checked[red_x][red_y][blue_x][blue_y] = true;

        xyd move_red , move_blue;
        while(!q.isEmpty()) {

            int size = q.size();
            while(size-- > 0) {
                Turn now = q.poll();

                for (int d = 0; d < 4; d++) {
                    move_red = move(now.red_x, now.red_y, 0, d);
                    move_blue = move(now.blue_x, now.blue_y, 0, d);

                    if(map[move_blue.r][move_blue.c] == 'O') continue;
                    if(map[move_red.r][move_red.c] == 'O') return 1;

                    if (move_red.r == move_blue.r && move_red.c == move_blue.c) {
                        if(move_red.dist> move_blue.dist) {
                            move_red.r -= dx[d];
                            move_red.c -= dy[d];
                        } else {
                            move_blue.r -= dx[d];
                            move_blue.c -= dy[d];
                        }
                    }

                    // 이미 시도해봤던 상태라면 pass
                    if(checked[move_red.r][move_red.c][move_blue.r][move_blue.c]) continue;

                    checked[move_red.r][move_red.c][move_blue.r][move_blue.c] = true;

                    // Queue에 추가
                    q.add(new Turn(move_red.r, move_red.c, move_blue.r, move_blue.c));
                }
            }

            // 10번 이하로 성공할 수 없다면
            if(++time > 10) return 0;
        }
        return 0;
    }

    private static xyd move(int x, int y, int dist, int d) {

        int temp_x = x, temp_y = y;
        // 다음 칸이 벽이 아니고, 현재 칸이 구멍이 아니라면 계속 이동
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

    static class Turn {
        int red_x, red_y, blue_x, blue_y;

        public Turn(int red_x, int red_y, int blue_x, int blue_y) {
            this.red_x = red_x;
            this.red_y = red_y;
            this.blue_x = blue_x;
            this.blue_y = blue_y;
        }
    }
}