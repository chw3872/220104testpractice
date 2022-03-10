import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int ten = 0;
        for (int i = 1; i <= 10; i++) {
            if (n < Math.pow(10, i)) {
                ten = i - 1;
                break;
            }
        }

        long answer = 0;
        for (int i = ten; i >= 0; i--) {
            int temp = (int) (n - Math.pow(10,i) + 1);
            answer = answer + temp;
        }

        System.out.println(answer % 1234567);
    }
}
