import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] numbers = new boolean[m + 1];
        numbers[1] =true;
        for (int i = 2; i <= m; i++) {
            if (numbers[i])
                continue;
            int temp = i;
            while (temp + i <= m) {
                temp += i;
                numbers[temp] = true;
            }
        }

        for (int i = n; i <= m; i++) {
            if (!numbers[i])
                System.out.println(i);
        }
    }
}

