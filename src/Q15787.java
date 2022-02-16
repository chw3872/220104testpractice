import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Q15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] trains = new boolean[n + 1][21];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            if (order == 1) {//태움
                int x = Integer.parseInt(st.nextToken());
                if (!trains[i][x])
                    trains[i][x] = true;
            } else if (order == 2) {
                int x = Integer.parseInt(st.nextToken());
                if (trains[i][x])
                    trains[i][x] = false;
            } else if (order == 4) {
                for (int idx = 1; idx < 20; idx++) {
                    trains[i][idx] = trains[i][idx + 1];
                }
            } else if (order == 3) {
                for (int idx = 20; idx > 0; idx--){
                    trains[i][idx] = trains[i][idx - 1];
                }
            }
        }
        HashSet<boolean[]> hashSet = new HashSet<>();
        for (int i = 1; i <= n; i++){
            if(!hashSet.contains(trains[i]))
                hashSet.add(trains[i]);
        }
        System.out.println(hashSet.size());
    }
}
