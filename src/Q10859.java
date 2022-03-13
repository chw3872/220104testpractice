import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] n = br.readLine().toCharArray();

        int[] numbers = {0, 1, 2, -1, -1, 5, 9, -1, 8, 6};

        String temp = "";
        for (int i = 0; i < n.length; i++) {
            temp += Character.getNumericValue(n[i]);
        }
        long bn = Long.parseLong(temp);
        if(bn == 1 || bn == 0)
        {
            System.out.println("no");
            return;
        }

        for (long i = 2; i * i <= bn; i++) {
            if (bn % i == 0) {
                System.out.println("no");
                return;
            }
        }

        String tn = "";
        for (int i = n.length - 1; i >= 0; i--) {
            if (n[i] == '3' || n[i] == '4' || n[i] == '7') {
                System.out.println("no");
                return;
            }
            tn += numbers[Character.getNumericValue(n[i])];
        }

        long nn = Long.parseLong(tn);

        for (long i = 2; i * i <= nn; i++) {
            if (nn % i == 0) {
                System.out.println("no");
                return;
            }
        }

        System.out.println("yes");
    }
}
