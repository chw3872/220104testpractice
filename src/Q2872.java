import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Q2872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] books = new int[n + 1];
        for (int i = 1; i <= n; i++)
            books[i] = Integer.parseInt(br.readLine());

        int number = n;
        int answer = 0;
        for (int i = n; i > 0; i--) {
            if (books[i] == number) {
                number--;
            } else {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
