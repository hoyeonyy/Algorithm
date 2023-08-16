import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int f, pre, goal, up, down;
    static int[] check;
    static int answer = 0;
    static int flag = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        pre = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());

        check = new int[f+1];
        BFS();
        if(flag == 0){
            System.out.println("use the stairs");
        }
        else{
            System.out.println(answer);
        }
    }
    static void BFS(){

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(pre);
        check[pre] = 1;
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int tmp = queue.poll();
                if(tmp == goal) {
                    flag = 1;
                    return;
                }
                if((tmp+up <= f) && check[tmp + up] == 0 ){
                    check[tmp + up] = 1;
                    queue.offer(tmp+up);
                }
                if( tmp-down >= 1 && check[tmp - down] == 0){
                    check[tmp - down] = 1;
                    queue.offer(tmp - down);
                }
            }
            answer++;
        }


    }


}