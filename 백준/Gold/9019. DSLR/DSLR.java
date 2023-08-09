import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int visited[];
    static char[] alpabet = {'D', 'S', 'L', 'R'};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            visited = new int[10004];
            System.out.println(bfs(a, b));

        }


    }

    public static String bfs(int n, int answer) {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, ""));
        visited[n] = 1;

        while(!q.isEmpty()) {
            Node tmp = q.poll();
            if(tmp.data == answer) 
                return tmp.str;
            for(int i = 0; i < 4; i++) {
                int change = DSLR(tmp.data, alpabet[i]);
                if(visited[change] == 0) {
                    visited[change] = 1;
                    q.offer(new Node(change, tmp.str + alpabet[i]));
                }
            }
        }
        return "";
    }
    public static class Node{
        int data;
        String str;

        public Node(int data, String str) {
            this.data = data;
            this.str = str;
        }
    }
    public static int DSLR(int n, char alpabet) {
        if(alpabet == 'D') {
            n *= 2;
            if(n > 9999) n %= 10000;
        } else if(alpabet == 'S') {
            n -= 1;
            if(n == -1) n = 9999;
        } else if(alpabet == 'L') {
            int temp1 = (n % 1000) * 10;
            int temp2 = n / 1000;
            n = temp1 + temp2;
        } else {
            int temp1 = n / 10;
            int temp2 = (n % 10) * 1000;
            n = temp1 + temp2;
        }
        return n;
    }


}