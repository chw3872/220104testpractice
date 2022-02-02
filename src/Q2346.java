import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int balloon = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Balloon> balloons = new LinkedList<>();
        for (int i = 0; i < balloon; i++) {
            int temp = Integer.parseInt(st.nextToken());
            balloons.add(new Balloon(i + 1, temp));
        }
        StringBuilder sb = new StringBuilder();

        while (!balloons.isEmpty()) {
            Balloon b = balloons.poll();
            int move = b.move;
            sb.append(b.num).append(" ");

            if (move < 0) {
                move += balloons.size();
            }
            else{
                move = move--;
            }

            for (int i = 0; i < move; i++) {
                Balloon tmp = balloons.poll();
                balloons.add(tmp);
            }


        }
        System.out.println(sb);
    }

    public static class Balloon {
        int num;
        int move;

        Balloon(int num, int move) {
            this.num = num;
            this.move = move;
        }
    }
}