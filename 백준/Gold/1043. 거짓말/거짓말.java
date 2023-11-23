import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int person;
    static int party;
    static int[] known;
    static int[][] partyMember;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        person = Integer.parseInt(st.nextToken());
        party = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        known = new int[n];
        for (int i = 0; i < n; i++) {
            known[i] = Integer.parseInt(st.nextToken());
        }
        partyMember = new int[party][];
        for (int i = 0; i < party; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            partyMember[i] = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                partyMember[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] checked = new int[person+1];

        for (int i : known) {
            checked[i] = 1;
        }

        for (int l = 0; l < party; l++) {
            for (int i = 0; i < party; i++) {

                for (int j = 0; j < partyMember[i].length; j++) {

                    if(checked[partyMember[i][j]] == 1){
                        for (int k = 0; k < partyMember[i].length; k++) {
                            checked[partyMember[i][k]] = 1;
                        }
                    }

                }
            }
        }
        int cnt = 0;
        int answer = 0;
        for (int i = 0; i < party; i++) {
            for (int j = 0; j < partyMember[i].length; j++) {
                if(checked[partyMember[i][j]] == 0){
                    cnt++;
                }
            }
            if(cnt == partyMember[i].length){
                answer++;
            }
            cnt = 0;
        }
        System.out.println(answer);
    }
}