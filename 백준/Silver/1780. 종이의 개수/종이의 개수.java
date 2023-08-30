import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int minus = 0;
    static int zero = 0;
    static int one = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }
    public static void dfs(int x, int y, int l) {

        if (isGood(x, y, l)) {
            if(board[x][y] == -1) {
                minus++;
            }
            else if(board[x][y] == 0) {
                zero++;
            }
            else {
                one++;
            }

            return;
        }
        int tmp = l / 3;
        dfs(x, y, tmp);
        dfs(x, y + tmp, tmp);
        dfs(x, y + 2 * tmp, tmp);
        dfs(x + tmp, y, tmp);
        dfs(x + tmp, y + tmp, tmp);
        dfs(x + tmp, y + 2 * tmp, tmp);
        dfs(x + 2 * tmp, y, tmp);
        dfs(x + 2 * tmp, y + tmp, tmp);
        dfs(x + 2 * tmp, y + 2 * tmp, tmp);
    }
    public static boolean isGood(int x, int y, int l) {
        int tmp = board[x][y];
        for (int i = x; i < x + l; i++) {
            for (int j = y; j < y + l; j++) {
                if (tmp != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}