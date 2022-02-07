import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int people = Integer.parseInt(br.readLine());
        boolean[][] friendship = new boolean[people][people];
        for (int i = 0; i < people; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < people; j++) {
                if (temp[j] == 'Y') {
                    friendship[i][j] = true;
                }
            }
        }
        int[] friends = new int[people];
        for (int i = 0; i < people; i++) {
            for (int j = 0; j < people; j++) {
                if (i == j)
                    continue;
                else if (friendship[i][j])
                    friends[i]++;
                else {
                    for (int k = 0; k < people; k++) {
                        if (i == k)
                            continue;
                        if (j == k)
                            continue;
                        if (friendship[i][k] && friendship[k][j]) {
                            friends[i]++;
                            break;
                        }
                    }
                }
            }
        }
        int maxFriend = 0;
        for (int i : friends) {
            maxFriend = Math.max(maxFriend, i);
        }

        System.out.println(maxFriend);
    }
}
