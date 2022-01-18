import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int x = 1; x <= t; x++) {
            int[][] map = new int[9][9];
            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Case ").append(x).append(": ");
            if (solution(map)) sb.append("CORRECT");
            else sb.append("INCORRECT");
            sb.append('\n');
            if (x < t) {
                String temp = br.readLine();
            }
        }
        System.out.println(sb);
    }

    public static boolean solution(int[][] map) {
        for (int i = 0; i < 9; i++) {
            boolean[] check = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (check[map[i][j]]) {
                    return false;
                }
                else {
                    check[map[i][j]] = true;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            boolean[] check = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (check[map[j][i]]) {
                    return false;
                }
                else {
                    check[map[j][i]] = true;
                }
            }
        }

        for (int i = 1; i < 8; i+=3) {
            for (int j = 1; j < 8; j+=3) {
                boolean[] check = new boolean[10];
                for(int k = -1; k <= 1; k++){
                    for(int l = -1; l <= 1; l++){
                        if(check[map[i+k][j+l]]) return false;
                        check[map[i+k][j+l]] = true;
                    }

                }
            }
        }

        return true;
    }
}

