import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int colrow = (int) Math.pow(2, N);
        int[][] ices = new int[colrow][colrow];
        for (int i = 0; i < colrow; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < colrow; j++)
                ices[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken());
            fireStorm(ices, L);
        }
    }

    public static void fireStorm(int[][] ices, int L) {
        int colrow = (int) Math.pow(2, L);
        int[][] tempArr = new int[colrow][colrow];
        for(int i = 0; i < ices.length; i++){
            for(int j = 0; j < ices.length; j++){

            }
        }
    }
}
