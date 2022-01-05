import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cur = Integer.parseInt(br.readLine());

        for (int idx = 0; idx < cur; idx++) {
            String str = br.readLine();
            Stack<Character> stringStack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if (stringStack.isEmpty())
                    stringStack.push(str.charAt(i));
                else {
                    if (str.charAt(i) == ')' && stringStack.peek() == '(')
                        stringStack.pop();
                    else
                        stringStack.push(str.charAt(i));
                }
            }
            if (!stringStack.isEmpty())
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}
