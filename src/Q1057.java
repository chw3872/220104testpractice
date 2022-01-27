import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int round = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int i = 1;
        for(i = 1; i <= round; i++){
            if(n % 2 == 0 && m % 2 == 1 && m+1 == n) {
                break;
            }
            else if(m % 2 == 0 && n % 2 == 1 && n + 1 == m){
                break;
            }
            if(n%2 == 1)
                n = n/2 + 1;
            else
                n = n/2;
            if(m%2 == 1)
                m = m/2 +1;
            else
                m = m/2;
        }
        if(i != round)
            System.out.println(i);
        else
            System.out.println(-1);
    }
}
