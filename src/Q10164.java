import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q10164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int point = Integer.parseInt(st.nextToken());

        long[][] map = new long[n + 1][m + 1];
        map[1][1] = 1;
        int pn = 0, pm = 0;
        if (point == 0 || point == n * m) {
            pn = n;
            pm = m;
        } else {
            if (point % m == 0) {
                pn = (point / m);
                pm = m;
            }
            else {
                pn = (point / m) + 1;
                pm = point % m;
            }
        }

        for (int i = 1; i <= pn; i++) {
            for (int j = 1; j <= pm; j++) {
                if (j - 1 > 0)
                    map[i][j] += map[i][j - 1];
                if (i - 1 > 0)
                    map[i][j] += map[i - 1][j];
            }
        }

        for (int i = pn; i <= n; i++) {
            for (int j = pm; j <= m; j++) {
                if (j - 1 >= pm)
                    map[i][j] += map[i][j - 1];
                if (i - 1 >= pn)
                    map[i][j] += map[i - 1][j];
            }
        }

        System.out.println(map[n][m]);

    }
}
