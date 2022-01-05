import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1065 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int value;
        value= sc.nextInt();

        if(value < 100) {
            System.out.println(value);
            return;
        }
        int cnt = 99;
        for(int i = value; i > 99; i--)
        {
            if(IsHanSu(i))
            {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

   public static boolean IsHanSu(int val) {
        String str = Integer.toString(val);
        int[] sub = new int[str.length() + 1];

        for (int i = 0; i < str.length() - 1; i++) {
            int temp = Character.getNumericValue(str.charAt(i + 1)) - Character.getNumericValue(str.charAt(i));
            if (i == 0) {
                sub[i] = temp;
            }
            else {
                if (temp != sub[i - 1])
                    return false;
            }
        }
        return true;
    }
}
