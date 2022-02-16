import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q20551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] inputArr = new int[N];
        int maxVal = 0;
        HashMap<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
            if (numbers.get(inputArr[i]) == null) {
                numbers.put(inputArr[i], 1);
            } else {
                numbers.replace(inputArr[i], numbers.get(inputArr[i]) + 1);
            }
            maxVal = Math.max(maxVal, inputArr[i]);
        }
        Object[] mapKey = numbers.keySet().toArray();
        Arrays.sort(mapKey);

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            int temp = Integer.parseInt(br.readLine());
            if(temp > maxVal){
                sb.append(-1).append("\n");
                continue;
            }
            int answer = 0;
            for(int i = 0; i < mapKey.length; i++){
                if(temp > Integer.parseInt(mapKey[i].toString())){
                    answer += numbers.get(mapKey[i]);
                }
                else if(temp == Integer.parseInt(mapKey[i].toString())){
                    sb.append(answer).append("\n");
                    break;
                }
                else{
                    sb.append(-1).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

}
