import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] temp = bf.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp[j] - '0';
            }
        }
        System.out.println(solution(n, m, map));
    }

    public static int solution(int n, int m, int[][] map) {
        int answer = 1, length = 0;
        if (n <= m) {
            length = n;
        } else {
            length = m;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = 1;
                for (int k = length; k > 0; k--) {

                    if (i + k < n && j + k < m) {
                        if (map[i][j] == map[i + k][j] && map[i][j] == map[i][j + k] && map[i][j] == map[i + k][j + k]) {
                            tmp = k + 1;
                            break;
                        }

                    }
                }
                if (tmp > answer)
                    answer = tmp;

            }
        }
        return answer * answer;
    }
}
