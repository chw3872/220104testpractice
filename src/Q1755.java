import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q1755 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] numList = new String[m - n + 1];
        int cnt = 0;
        for (int i = n; i <= m; i++) {
            int temp = i;
            String t = "";
            while (temp >= 10){
                int tens = temp / 10;
                temp = temp % 10;
                t += (numbers[tens] + " ");
            }
            t+=numbers[temp];
            numList[cnt++] = t;
        }
        Arrays.sort(numList);

        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> toNum = new HashMap<>();
        toNum.put("zero", 0);
        toNum.put("one", 1);
        toNum.put("two", 2);
        toNum.put("three", 3);
        toNum.put("four", 4);
        toNum.put("five", 5);
        toNum.put("six", 6);
        toNum.put("seven", 7);
        toNum.put("eight", 8);
        toNum.put("nine", 9);

        cnt = 0;
        for(int i = 0; i < numList.length; i++){
            String[] temp = numList[i].split(" ");
            for(int j = 0; j < temp.length; j++){
                sb.append(toNum.get(temp[j]));
            }
            sb.append(" ");
            cnt++;
            if(cnt == 10){
                sb.append("\n");
                cnt = 0;
            }
        }
        System.out.println(sb);
    }
}
