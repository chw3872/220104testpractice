import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("(()))(");
    }
}

class Solution {
    public String solution(String p) {
        if (p == "")
            return "";
        String answer = "";
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        int isBad = p.length() + 1;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                stack.add('(');
                cnt++;
            } else {
                if (!stack.isEmpty())
                    stack.pop();
                else {
                    isBad = i;
                    break;
                }
                cnt--;
            }
        }

        return answer;
    }

    public String fixBracket(String p, int i) {
        String front = p.substring(0, i);
        String back = p.substring(i + 1);
        return "";
    }
}
