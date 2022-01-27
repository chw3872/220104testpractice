import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            String inputStr = br.readLine();
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            sb.append(leastGame(inputStr, k)).append(" ");
        }
        System.out.println(sb);
    }
    public static int leastGame(String str, int k){
        int aLength = 'z' - 'a' + 1;
        int[] alphabets = new int[aLength];

        int answer = str.length() + 1;
        for(int i = k; i < str.length(); i++){
            for(int j = 0; j + i < str.length(); j++){
                if(j == 0){
                    for(int idx = 0; idx < i; idx++) {
                        alphabets[str.charAt(j + idx) - 'a']++;
                    }
                }
                else{
                    alphabets[str.charAt(j - 1) - 'a']--;
                    alphabets[str.charAt(j + i) - 'a']++;
                    for(int idx = 0; idx < i; idx++){
                        if(alphabets[str.charAt(j + idx) - 'a'] == 2)
                            return i;
                    }
                }
            }
        }

        return answer;
    }
}
