import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int bottle = 0;
        int nb = n;
        while(true) {
            int cnt = 0;
            while (nb > 0) {
                if (nb % 2 == 1)
                    cnt++;
                nb = nb / 2;
            }
            if(cnt <= k)
                break;
            bottle++;
            nb = n + bottle;
        }
        System.out.println(bottle);

    }
}
