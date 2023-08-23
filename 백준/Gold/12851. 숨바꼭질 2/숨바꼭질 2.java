import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int one;
    static int two;
    static boolean check[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        one = Integer.parseInt(st.nextToken());
        two = Integer.parseInt(st.nextToken());
        check = new boolean[100001];

        bfs();

    }
    public static void bfs(){
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(one);
        int result=Integer.MAX_VALUE;
        int visit=0;
        int level = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int i=0; i<size; i++) {
                int temp = q.poll();
                check[temp] = true;

                if(temp == two) {
                    if(result >= level) {
                        result = level;
                        visit++;
                    }
                }
                if(temp-1 >= 0 && !check[temp-1]) {
                    q.add(temp-1);
                }
                if(temp+1 < 100001 && !check[temp+1]) {
                    q.add(temp+1);
                }
                if(temp*2 < 100001 && !check[temp*2]) {
                    q.add(temp*2);
                }
            }
        }
        System.out.println(result);
        System.out.println(visit);

    }

}