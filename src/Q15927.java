import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();
        char[] reverseChars = new char[chars.length];

        for(int i = 0; i < chars.length; i++){
            reverseChars[i] = chars[chars.length - i];
        }

    }
}
