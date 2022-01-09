import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q17204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] pointed = new int[n];
        int i = 0;
        boolean[][] map = new boolean[n][n];
        while (n-- > 0){
            pointed[i] = Integer.parseInt(br.readLine());
            map[i][pointed[i]] = true;
            i++;
        }
        System.out.println(solution(map, k));

    }
    public static int solution(boolean[][] map, int k){
        int[] depth = new int[map.length];
        boolean[] visited = new boolean[map.length];

        int now = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(now);
        depth[now] = 0;

        while(!stack.isEmpty()){
            now = stack.pop();
            if(visited[now])
                continue;
            else
                visited[now] = true;

            for(int i = 0; i < map.length; i++) {
                if (map[now][i] && !visited[i]) {
                    stack.add(i);
                    depth[i] = depth[now] + 1;
                }
            }
        }
        if(visited[k])
            return depth[k];
        else
            return -1;
    }
}
