import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException{
        int T=10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case=1; test_case<=T; test_case++) {
            int tc= Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
             
            String input[] = br.readLine().split(" ");
            for(int i=0; i<8; i++) {
                queue.add(Integer.parseInt(input[i]));
            }
             
            boolean run = true;
            while(run) {
                for(int i=1; i<=5; i++) {
                    int num  = queue.poll();
                    int after = num - i;
                    if(after <= 0 ) {
                        queue.add(0);
                        run =false;
                        break;
                    }
                    queue.add(after);
                }
                 
            }
        System.out.print("#"+test_case+" " );
        queue.stream().forEach(i->System.out.print(i+" "));
        System.out.println();
        }
    }
}