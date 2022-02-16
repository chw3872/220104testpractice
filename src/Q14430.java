import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] resources = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i != 0 && j != 0)
                    resources[i][j] = Math.max(resources[i - 1][j], resources[i][j - 1]) + map[i][j];
                else if (i == 0 && j != 0)
                    resources[i][j] = resources[i][j - 1] + map[i][j];
                else if (i != 0 && j == 0)
                    resources[i][j] = resources[i - 1][j] + map[i][j];
                else if (i == 0 && j == 0)
                    resources[i][j] = map[i][j];
            }
        }
        System.out.println(resources[n - 1][m - 1]);
    }
}
