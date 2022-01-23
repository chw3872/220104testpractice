import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] isbroken = new boolean[n + 1];
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            isbroken[idx] = true;
        }
        int answer = k;
        for (int i = 1; i <= n - k + 1; i++) {
            int temp = 0;
            for (int j = 0; j < k; j++) {
                if (isbroken[i + j])
                    temp++;
            }
            if (answer > temp)
                answer = temp;
        }

        System.out.println(answer);
    }
}
