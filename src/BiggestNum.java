import java.util.Arrays;
import java.util.Comparator;

public class BiggestNum {
    public static void main(String[] args) {
        String result = soluton(new int[]{3, 30, 34, 5, 9});
        System.out.println(result);
    }
    public static String soluton(int[] numbers) {
        String answer = "";
        String[] temp = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++)
            temp[i] = Integer.toString(numbers[i]);

        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               return (o1+o2).compareTo(o2+o1);
            }
        });

        for (int i = temp.length - 1; i >= 0; i--)
            answer += temp[i];
        String tmp = "";
        for(int i = 0; i < temp.length; i++)
            tmp +="0";

        if(answer.compareTo(tmp) == 0)
            answer = "0";
        return answer;
    }
}
