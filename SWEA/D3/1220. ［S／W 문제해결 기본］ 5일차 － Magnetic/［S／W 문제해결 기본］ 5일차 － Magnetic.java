import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
 
        for(int t=1; t<=10; t++){
            int size = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            for(int i=0; i<100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int state = 0;
            for(int i =0; i<size; i++){
                int last =0;
                for(int j =0; j<size; j++){
                    if(arr[j][i]==1){
                        last=1;
                    }
                    if(arr[j][i]==2 && last == 1){
                        state++;
                        last = 0;
                    }
                }
            }
            System.out.println("#"+t+" "+state);
        }
 
 
 
    }
}