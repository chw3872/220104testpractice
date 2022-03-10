import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Q11068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            boolean ableTo = false;
            for(int i = 2; i <= 64; i++){
                if(changeSystem(i, n)) {
                    System.out.println(1);
                    ableTo = true;
                    break;
                }
            }
            if(!ableTo)
                System.out.println(0);
        }
    }
    public static boolean changeSystem(int n, int num){
        String answer = "";
        int digit = 0;
        int temp = num;
        int max = 1000000 / n;
        for(int i = 1; i <= max; i++){
            if(num < Math.pow(n, i)){
                digit = i - 1;
                break;
            }
        }
        while (temp > 0){
            answer += temp / (int) Math.pow(n, digit);
            temp = temp % (int) Math.pow(n, digit--);
        }

        for(int i = 0; i < answer.length()/2; i++){
            if(answer.charAt(i) != answer.charAt(answer.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}
