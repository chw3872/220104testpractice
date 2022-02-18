import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int now = n * n;
        int ax = 0, ay = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int direction = 0;
        int nx = 0, ny = 0;
        map[0][0] = now--;
        while (now > 0){
            int nextX = nx+dx[direction];
            int nextY = ny+dy[direction];
            if(nextX < 0 || nextX >= n || )
            if((nx + dx[direction] >= 0 && ny + dy[direction] >= 0) && (nx + dx[direction] < n && ny + dy[direction] < n)){
                if(map[nx + dx[direction]][ny + dy[direction]] == 0) {
                    nx += dx[direction];
                    ny += dy[direction];
                    map[nx][ny] = (now--);
                }

                else{
                    direction = (++direction) % 4;
                }
            }
            else{
                direction = (++direction) % 4;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(map[i][j] + " ");
                if(map[i][j] == m){
                    ax = i + 1;
                    ay = j + 1;
                }
            }
            System.out.println();
        }
        System.out.println(ax + " " + ay);
    }
}
