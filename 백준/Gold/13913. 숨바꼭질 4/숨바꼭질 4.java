import java.util.*;
import java.io.*;

public class Main {
    static int one, two;
    static int[] parent = new int[100001];
    static int[] check = new int[100001];
    static int level = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        one = Integer.parseInt(st.nextToken());
        two = Integer.parseInt(st.nextToken());
        if(one == two){
            System.out.println(0);
            System.out.println(one);
        }else{
            bfs();
            System.out.println(level);
            Stack<Integer> stack = new Stack<>();
            while (true){
                stack.push(two);
                two = parent[two];
                if(two == one) {
                    stack.push(two);
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            while (true){
                Integer pop = stack.pop();
                sb.append(pop).append(' ');
                if(stack.isEmpty())break;
            }
            System.out.println(sb);
        }

    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(one);
        check[one] = 1;

        while (!q.isEmpty()) {
            int len = q.size();
            level++;
            for (int j = 0; j < len; j++) {
                int tmp = q.poll();
                if (tmp == two) return;
                for (int i=0; i<3; i++) {
                    int x;
                    if (i == 0){
                        x = tmp + 1;
                    }
                    else if (i == 1){
                        x = tmp - 1;
                    }
                    else {
                        x = tmp * 2;
                    }
                    if (x < 0 || x > 100000) continue;
                    if (check[x] == 0) {
                        check[x] = 1;
                        q.offer(x);
                        parent[x] = tmp;
                    }
                }
            }
        }
    }
}
