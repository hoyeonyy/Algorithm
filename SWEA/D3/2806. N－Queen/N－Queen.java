import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static int[] ar;
    public static int n;
    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase= Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            count = 0;
            n = Integer.parseInt(br.readLine());
            ar = new int[n];

            nQueen(0);
            System.out.println("#" + (i+1) + " " + count);
        }
    }

    public static void nQueen(int depth) {
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            ar[depth] = i;
            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }
    public static boolean Possibility(int depth) {
        for (int i = 0; i < depth; i++) {
            if (ar[depth] == ar[i]) {
                return false;
            }
            else if (Math.abs(depth - i) == Math.abs(ar[depth] - ar[i])) {
                return false;
            }
        }
        return true;
    }
}