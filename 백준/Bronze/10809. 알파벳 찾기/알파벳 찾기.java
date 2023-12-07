import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String tmp = "abcdefghijklmnopqrstuvwxyz";
        for (char c : tmp.toCharArray()) {
            if(s.contains(String.valueOf(c))){
                System.out.print(s.indexOf(c)+ " ");
            }
            else{
                System.out.print("-1 ");
            }
        }

    }
}