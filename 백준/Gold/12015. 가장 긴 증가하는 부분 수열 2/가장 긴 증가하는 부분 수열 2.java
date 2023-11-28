import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();

        list.add(ar[0]);
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            int tmp = ar[i];
            if (list.get(cnt - 1) < tmp) {
                cnt++;
                list.add(tmp);
            }
            else {
                int lt = 0;
                int rt = cnt;
                while (lt < rt) {
                    int mid = (lt + rt)/2;
                    if(list.get(mid) < tmp) {
                        lt = mid + 1;
                    }
                    else {
                        rt = mid;
                    }
                }
                list.set(lt, tmp);
            }
        }
        System.out.println(cnt);
    }
}