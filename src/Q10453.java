import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q10453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] a = st.nextToken().toCharArray();
            char[] b = st.nextToken().toCharArray();

            int cnt = 0;
            while (!a.equals(b)) {
                for (int i = a.length - 1; i > 0; i--) {
                    if (a[i - 1] == 'b' && a[i] == 'a') {
                        char temp = a[i];
                        a[i] = a[i + 1];
                        a[i + 1] = temp;
                        if (!isGood(a)) {
                            cnt = -1;
                            break;
                        }
                        break;
                    }
                }
                if (cnt != -1)
                    cnt++;
                else
                    break;
            }
            sb.append(cnt).append("\n");
        }

    }

    public static boolean isGood(char[] s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length; i++) {
            if (stack.isEmpty() && s[i] == 'b')
                return false;
            else if (s[i] == 'b') {
                stack.pop();
            } else {
                stack.add(s[i]);
            }
        }
        if (!stack.isEmpty())
            return false;
        else
            return true;
    }
}
