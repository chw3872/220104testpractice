import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int MAX = 1000001;
        // do로 1_000_000까지 계산 다 해놓음
        long[] sum = new long[MAX];

        Arrays.fill(sum, 1);
        for(int i = 2; i < MAX; i++){
            for(int j = 1; j * i < MAX; j++){
                sum[i*j] += i;
            }
        }
        long[] answer = new long[MAX];
        for(int i = 1; i < MAX; i++){
            answer[i] += answer[i - 1] + sum[i];
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            sb.append(answer[n]).append("\n");
        }
        System.out.println(sb);
    }
}
