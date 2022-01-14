import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String room = br.readLine();
        int[] cnt = new int[10];
        for (int i = 0; i < room.length(); i++) {
            int idx = Character.getNumericValue(room.charAt(i));
            cnt[idx]++;
        }
        int temp = cnt[6] + cnt[9];
        if (temp % 2 == 1)
            cnt[6] = (temp / 2) + 1;
        else {
            cnt[6] = temp / 2;
            cnt[9] = 0;
        }
        int max = 0;
        for (int i = 0; i <= 8; i++) {
            if (max <= cnt[i])
                max = cnt[i];
        }
        System.out.println(max);
    }
}
