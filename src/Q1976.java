import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[n+1][n+1];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1)
                    map[i+1][j+1] = true;
                else
                    map[i+1][j+1] = false;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> route = new LinkedList<>();
        for(int i = 0; i < m; i++){
            int temp = Integer.parseInt(st.nextToken());
            route.add(temp);
        }
        rearrangeMap(map);

        int now = route.poll();
        while(!route.isEmpty()){
            int next = route.poll();
            if(!map[now][next]){
                System.out.println("NO");
                return;
            }
        }

        if(route.isEmpty())
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static void rearrangeMap(boolean[][] map){
        for(int i = 1; i < map.length; i++){
            for(int j = 1; j < map.length; j++){
                if(i != j && !map[i][j]) {
                    Queue<Integer> queue = new LinkedList<>();
                    boolean[] visited = new boolean[map.length];
                    int now = i;
                    queue.add(i);
                    while (!queue.isEmpty()) {
                        now = queue.poll();
                        if (visited[now])
                            break;
                        visited[now] = true;
                        if (now == j)
                            break;
                        for (int k = 1; k < map.length; k++) {
                            if (k != now && !visited[k] && map[now][k]) {
                                queue.add(k);
                                map[i][k] = true;
                                map[k][i] = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
