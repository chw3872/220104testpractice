import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> presents = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 0){
                if(!presents.isEmpty())
                    sb.append(presents.poll()).append("\n");
                else
                    sb.append(-1).append("\n");
            }
            else{
                 for(int j = 0; j < a; j++){
                     int temp = Integer.parseInt(st.nextToken());
                     presents.add(temp);
                }
            }
        }
        System.out.println(sb);
    }
}
