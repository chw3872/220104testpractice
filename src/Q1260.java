import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] info = new int[3];
        info[0] = Integer.parseInt(st.nextToken());
        info[1] = Integer.parseInt(st.nextToken());
        info[2] = Integer.parseInt(st.nextToken());

        int[][] map = new int[info[0] + 1][info[0] + 1];

        for (int i = 0; i <= info[0]; i++){
            for(int j = 0; j <= info[0]; j++){
                map[i][j] = 0;
            }
        }

        for (int i = 0; i < info[1]; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[s][d] = 1;
            map[d][s] = 1;
        }

        DFS(map, info);

        BFS(map, info);


    }
    public static void DFS(int[][] map, int[] info)
    {
        boolean[] visited = new boolean[info[0] + 1];

        Stack<Integer> s = new Stack<>();
        int strPoint = info[2];
        s.add(strPoint);

        while(!s.isEmpty())
        {
            strPoint = s.pop();;
            if(visited[strPoint])
                continue;
            else
                visited[strPoint] = true;
            System.out.print(strPoint + " ");

            for(int i = info[0]; i > 0; i--)
            {
                if(map[strPoint][i] == 1 && !visited[i])
                {
                    s.add(i);

                }
            }
        }
        System.out.println();
        return;
    }
    public static void BFS(int[][] map, int[] info)
    {
        boolean[] visted = new boolean[info[0] + 1];

        Queue<Integer> q = new ArrayDeque<>();
        int strPoint = info[2];
        q.add(strPoint);

        while(!q.isEmpty())
        {
            strPoint = q.remove();
            if(visted[strPoint])
                continue;
            else
                visted[strPoint] = true;
            System.out.print(strPoint + " ");

            for(int i = 1; i <= info[0]; i++)
            {
                if(map[strPoint][i] == 1 && !visted[i])
                {
                    q.add(i);
                }
            }
        }
        System.out.println();
        return;
    }
}
