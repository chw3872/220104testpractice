import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1091 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] s = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int[] cards = new int[n];
        int[] tempcards = new int[n];
        ArrayList<int[]> shuffles = new ArrayList<>();
        for (int i = 0; i < n; i++)
            cards[i] = i;
        shuffles.add(cards);

        while (true) {
            for (int i = 0; i < n; i++) {
                tempcards[s[i]] = cards[i];
            }
            cards = tempcards.clone();
            boolean isComeback = true;
            for (int i = 0; i < n; i++) {
                if (cards[i] != i) {
                    isComeback = false;
                    break;
                }
            }
            if (!isComeback)
                shuffles.add(cards);
            else {
                break;
            }
        }

        int shuffleNum = 0;
        boolean success = true;
        while (!shuffles.isEmpty()) {
            int[] tempCards = shuffles.get(0);
            shuffles.remove(0);

            int[] players = new int[n];
            int cnt = 0;
            success = true;
            for (int i = 0; i < n; i++) {
                if (p[tempCards[i]] != (i % 3)) {
                    success = false;
                    break;
                }
            }
            if (success) {
                System.out.println(shuffleNum);
                break;
            }
            shuffleNum++;
        }
        if (!success) {
            System.out.println(-1);
        }
    }
}
