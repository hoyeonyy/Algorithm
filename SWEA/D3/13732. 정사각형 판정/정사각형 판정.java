import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    private static int n;
    private static char[][] board;
    private static int[][] checked;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            n = sc.nextInt();
            board = new char[n][n];
            checked = new int[n][n];
            int flag = 0;
            String answer = "yes";
            for (int i = 0; i < n; i++) {
                String input = sc.next();
                board[i] = input.toCharArray();
            }
            Point min = new Point(0,0);
            Point max = new Point(0, 0);
            for (int i = 0; i < n; i++) {
                if(flag == 1)break;
                for (int j = 0; j < n; j++) {
                    if(board[i][j] == '#'){
                        min = new Point(i, j);
                        flag = 1;
                        break;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(board[i][j] == '#'){
                        max = new Point(i, j);
                    }
                }
            }
            for (int i = min.x; i <= max.x; i++) {
                for (int j = min.y; j <= max.y; j++) {
                    if(board[i][j] == '.'){
                        answer = "no";
                    }
                }
            }
            for (int i = min.x; i <= max.x; i++) {
                for (int j = min.y; j <= max.y; j++) {
                    checked[i][j] = 1;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(checked[i][j] ==0 && board[i][j] == '#'){
                        answer = "no";
                    }
                }
            }
            if(max.y - min.y != max.x - min.x){
                answer = "no";
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}