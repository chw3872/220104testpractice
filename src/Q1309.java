import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cage = new int[n][3];

        cage[0][0] = 1;     //해당 줄에 없는 경우
        cage[0][1] = 1;     //첫번째줄에 있는 경우
        cage[0][2] = 1;     //두번째줄에 있는 경우

        for (int i = 1; i < n; i++) {
            //해당 즐에 없는 경우
            cage[i][0] = (cage[i - 1][0] + cage[i - 1][1] + cage[i - 1][2]) % 9901;

            //첫 번째줄에 사자가 있는 경우
            cage[i][1] = (cage[i - 1][0] + cage[i - 1][2]) % 9901;

            //두번째줄에 사자가 있는 경우
            cage[i][2] = (cage[i - 1][0] + cage[i - 1][1]) % 9901;
        }
        System.out.println((cage[n - 1][0] + cage[n - 1][1] + cage[n - 1][2]) % 9901);
    }
}
