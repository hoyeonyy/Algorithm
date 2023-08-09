import java.io.*;
import java.util.*;

public class Main {

    static int l, c;
    static char[] input;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        input = new char[c];
        st = new StringTokenizer(br.readLine());

        for (int x = 0; x < c; x++) {
            input[x] = st.nextToken().charAt(0);
        }
        Arrays.sort(input);

        String result = new String();


        dfs(result, 0);


    }

    public static void dfs(String result, int x){

        if(x == c){
            if(result.length() == l){
                if(isgood(result)) System.out.println(result);
            }
            else{
                return;
            }
        }
        else{
            dfs(result+input[x], x+1);
            dfs(result, x+1);
        }

    }

    public static boolean isgood(String result) {
        int moum = 0;
        int jaum = 0;

        for (char x : result.toCharArray()) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                moum++;
            } else {
                jaum++;
            }
        }

        if (moum >= 1 && jaum >= 2) {
            return true;
        }
        return false;
    }

}