import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q15649 {
    public static int n, m;
    public static boolean[] visited;
    public static int[] answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        answer = new int[m];

        solution( 0);
    }



    public static void solution(int depth) {
        if (depth == m-1) {
            for (int val : answer) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = i;
                solution(depth);

                visited[i] = false;
            }
        }
    }
}
