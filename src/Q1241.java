import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1241 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[1000001];

        int[] students = new int[N];
        int maxVal = 0;
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(br.readLine());
            cnt[students[i]]++;
            maxVal = Math.max(maxVal, students[i]);
        }

        int[] hits = new int[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            if (cnt[i] > 0) {
                int temp = i;
                while (temp <= maxVal) {
                    hits[temp] += cnt[i];
                    temp += i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(hits[students[i]] - 1).append("\n");
        }
        System.out.println(sb);
    }
}
