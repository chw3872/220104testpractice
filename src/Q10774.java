import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10774 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int j = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());

        int[] sizes = new int[j];
        Clothes[] clothes = new Clothes[a];
        for (int i = 0; i < j; i++) {
            char temp = br.readLine().charAt(0);
            if(temp == 'S')
                sizes[i] = 1;
            else if(temp == 'M')
                sizes[i] = 2;
            else if(temp =='L')
                sizes[i] = 3;
        }

        for (int i = 0; i < a; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char size = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken()) + 1;
            clothes[i] = new Clothes(size, num);
        }

        int answer = 0;
        boolean[] taken = new boolean[j];
        for (int i = 0; i < a; i++) {
            if (taken[i])
                continue;
            if (sizes[clothes[i].num] >= clothes[i].size) {
                answer++;
                taken[i] = true;
            }
        }
        System.out.println(answer);
    }

    public static class Clothes {
        int size;
        int num;

        Clothes(char size, int num) {
            if(size == 'S')
                this.size = 1;
            else if(size == 'M')
                this.size = 2;
            else if(size =='L')
                this.size = 3;

            this.num = num;
        }
    }
}
