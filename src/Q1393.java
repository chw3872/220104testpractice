import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1393 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int xs = Integer.parseInt(st.nextToken());
        int ys = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int xe = Integer.parseInt(st.nextToken());
        int ye = Integer.parseInt(st.nextToken());

        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());

        int GCD = findGCD(dx, dy);
        dx /= GCD;
        dy /= GCD;

        double length = Math.sqrt((xs - xe) * (xs - xe) + (ys - ye) * (ys - ye));
        int ax = xe, ay = ye;
        while (true) {
            xe += dx;
            ye += dy;

            double temp = Math.sqrt((xs - xe) * (xs - xe) + (ys - ye) * (ys - ye));
            if (temp < length) {
                length = temp;
                ax = xe;
                ay = ye;
            }
            if (temp > length)
                break;
        }
        System.out.println(ax + " " + ay);
    }

    public static int findGCD(int a, int b) {
        int answer = 1;
        for (int i = a; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
