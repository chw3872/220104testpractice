import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(bf.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            boolean[][] map = new boolean[n + 1][n + 1];
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(bf.readLine());
                int str = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());

                map[str][dest] = true;
                map[dest][str] = true;
            }

            System.out.println(n-1);
        }
    }
}
