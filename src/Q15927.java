import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();

        boolean palindrome = true;
        for(int i = 0; i < chars.length / 2; i++){
            if(chars[i] != chars[chars.length - i - 1]){
                palindrome = false;
            }
        }


        if(palindrome)
        {
            char c = chars[0];
            boolean isSame = true;
            for(int i = 1; i < chars.length; i++)
            {
                if(c != chars[i]){
                    isSame = false;
                    break;
                }
            }
            if(!isSame){
                System.out.println(chars.length-1);
            }
            else
                System.out.println(-1);
        }else{
            System.out.println(chars.length);
        }
    }
}
