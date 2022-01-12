import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] classes = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            classes[i][0] = Integer.parseInt(st.nextToken());
            classes[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(classes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0])
                    return -1;
                else if (o1[0] > o2[0])
                    return 1;
                return 0;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(classes[0][1]);
        for (int i = 1; i < n; i++) {
            int temp = pq.peek();
            if(temp <= classes[i][0]){
                pq.poll();
            }
            pq.add(classes[i][1]);
        }
        System.out.println(pq.size());
    }
}
