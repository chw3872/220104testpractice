import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10570 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int v = Integer.parseInt(br.readLine());

            int[] memo = new int[1001];
            for (int i = 0; i < v; i++) {
                int temp = Integer.parseInt(br.readLine());
                memo[temp]++;
            }

            int maxVal = 0;
            int answer = 0;
            for (int i = 1; i <= 1000; i++) {
                if (maxVal < memo[i]) {
                    maxVal = memo[i];
                    answer = i;
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
