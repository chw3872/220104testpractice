import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3987 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int x = 0; x < n; x++) {
            char[] arr = br.readLine().toCharArray();
            for (int y = 0; y < m; y++) {
                map[x][y] = arr[y];
            }
        }

        st = new StringTokenizer(br.readLine());
        int pr = Integer.parseInt(st.nextToken());
        int pc = Integer.parseInt(st.nextToken());

        int answer = 0;
        int direction = 0;
        for (int i = 0; i < 4; i++) {
            int temp = travel(i, map, pr, pc);
            if (answer < temp) {
                answer = temp;
                direction = i;
            } else if (temp == -1) {
                answer = -1;
                direction = i;
                break;
            }
        }

        if (direction == 0)
            System.out.println("U");
        else if (direction == 1)
            System.out.println("R");
        else if (direction == 2)
            System.out.println("D");
        else if (direction == 3)
            System.out.println("L");
        if (answer == -1)
            System.out.println("Voyager");
        else
            System.out.println(answer);
    }

    public static int travel(int direction, char[][] map, int posx, int posy) {
        int cnt = 1;
        position p = new position(posx - 1, posy - 1);
        boolean[][][] visited = new boolean[map.length][map[0].length][4];
        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        visited[p.x][p.y][direction] = true;

        while (map[p.x][p.y] != 'C') {
            if (p.x + move[direction][0] < 0 || p.x + move[direction][0] >= map.length)
                break;
            if (p.y + move[direction][1] < 0 || p.y + move[direction][1] >= map[0].length)
                break;
            p.x += move[direction][0];
            p.y += move[direction][1];
            cnt++;

            if (visited[p.x][p.y][direction])
                return -1;
            else
                visited[p.x][p.y][direction] = true;

            if (map[p.x][p.y] == '\\') {
                if (direction == 0)
                    direction = 3;
                else if (direction == 1)
                    direction = 2;
                else if (direction == 2)
                    direction = 1;
                else if (direction == 3)
                    direction = 0;
            } else if (map[p.x][p.y] == '/') {
                if (direction == 0)
                    direction = 1;
                else if (direction == 1)
                    direction = 0;
                else if (direction == 2)
                    direction = 3;
                else if (direction == 3)
                    direction = 2;
            }
        }
        if(map[p.x][p.y] == 'C')
            cnt--;
        return cnt;
    }

    public static class position {
        int x;
        int y;

        position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
