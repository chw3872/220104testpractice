import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] score = new int[3];
        String[] time = {"", "00:00", "00:00"};
        int winner = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String stime = st.nextToken().toString();
            if(winner == 0) {
                score[team]++;
                winner = team;
                time[winner] = stime;
            }
            else if(winner == 1){
                if(team == 1)
                    score[team]++;
                else{
                    if(++score[team] > score[2]){
                        winner = 1;
                        time[winner] = stime;
                    }
                }
            }
            else if(winner == 2){
                if(team == 2)
                    score[team]++;
                else{
                    if(++score[team] > score[1]){
                        winner = 2;
                        time[winner] = stime;
                    }
                }
            }
        }
        System.out.println(time[1]);
        System.out.println(time[2]);
    }
}
