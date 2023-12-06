import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String real = str.toUpperCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : real.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = 0;
        char tmp = ' ';
        for (Character character : map.keySet()) {
            if(max < map.get(character)){
                max = map.get(character);
                tmp = character;
            }
        }
        int cnt = 0;
        for (Character character : map.keySet()) {
            if(max == map.get(character))cnt++;
        }
        if(cnt >= 2){
            System.out.println("?");
        }
        else{
            System.out.println(tmp);
        }
    }
}