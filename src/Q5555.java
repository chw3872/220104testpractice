import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q5555 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ring = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Queue<Character>[] letters = new Queue[n];
        for(int i = 0; i < n; i++){
            char[] temp = br.readLine().toCharArray();
            letters[i] = new LinkedList<>();
            for(int j = 0; j < 10; j ++){
                letters[i].add(temp[j]);
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 10; j++) {
                String temp = "";
                for(int k = 0; k < 10; k++){
                    char c = letters[i].poll();
                    temp += c;
                    letters[i].add(c);
                }
                if (temp.contains(ring)) {
                    answer++;
                    break;
                }
                else {
                    char c = letters[i].poll();
                    letters[i].add(c);
                }
            }
        }
        System.out.println(answer);
    }
}
