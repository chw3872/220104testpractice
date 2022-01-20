import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                if (line[j - 1] == '1')
                    map[i][j] = true;
                else
                    map[i][j] = false;
            }
        }
        System.out.println(bfs(map, n, m));
    }

    public static int bfs(boolean[][] map, int n, int m) {

        Queue<pnt> q = new LinkedList<>();
        int[][] visited = new int[n + 1][m + 1];
        pnt pnow = new pnt(1, 1);
        visited[pnow.x][pnow.y] = 1;
        q.offer(pnow);

        int[] mx = {0, 1, -1, 0};
        int[] my = {1, 0, 0, -1};
        while (!q.isEmpty()) {
            pnow = q.poll();
            if (pnow.x == n && pnow.y == m)
                break;

            for (int i = 0; i < mx.length; i++) {
                if (pnow.x + mx[i] <= n && pnow.y + my[i] <= m && pnow.x + mx[i] > 0 && pnow.y + my[i] > 0) {
                    if (map[pnow.x + mx[i]][pnow.y + my[i]] && visited[pnow.x + mx[i]][pnow.y + my[i]] == 0) {
                        pnt temp = new pnt(pnow.x + mx[i], pnow.y + my[i]);
                        visited[pnow.x+mx[i]][pnow.y+my[i]] = visited[pnow.x][pnow.y] + 1;
                        q.offer(temp);

                    }
                }
            }
        }
        return visited[n][m];
    }

    public static class pnt {
        int x;
        int y;

        pnt(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
