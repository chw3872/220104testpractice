import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> cards = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            cards.add(temp);
        }

        int answer = 0;
        while (cards.size() > 1) {
            int t1 = cards.poll();
            int t2 = cards.poll();

            answer += (t1 + t2);
            cards.add(t1 + t2);
        }

        System.out.println(answer);
    }
}
