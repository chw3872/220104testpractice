import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        int maxDist = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Queue<int[]> queue = new LinkedList<>();
                int[][] dist = new int[n][m];
                int[] now = {i, j};
                dist[now[0]][now[1]] = 0;
                queue.add(now);
                boolean isShark = false;
                while (!queue.isEmpty()){
                    now = queue.poll();
                    for(int k = 0; k < 8; k++){
                        int nx = now[0] + dx[k];
                        int ny = now[1] + dy[k];
                        if((nx >= 0 && nx < n) && (ny >= 0 && ny < m) && dist[nx][ny] == 0){
                            queue.add(new int[]{nx, ny});
                            dist[nx][ny] = dist[now[0]][now[1]] + 1;
                            if(map[nx][ny] == 1)
                            {
                                maxDist = Math.max(maxDist, dist[nx][ny]);
                                isShark = true;
                                break;
                            }
                        }
                        else
                            continue;
                    }
                    if(isShark)
                        break;
                }
            }
        }
        System.out.println(maxDist);
    }
}
