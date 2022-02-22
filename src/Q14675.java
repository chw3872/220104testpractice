import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q14675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            map.add(new ArrayList<>());

        for(int i = 0; i < n - 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        while (q-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(t == 1){
                if(map.get(num).size() > 1)
                    sb.append("yes").append("\n");
                else
                    sb.append("no").append("\n");
            }
            else{
                sb.append("yes").append("\n");
            }
        }
        System.out.println(sb);
    }
}
