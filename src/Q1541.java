import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] numbers = str.split("-");

        int answer = 0;
        for(int i = 0; i < numbers.length; i++){
            String[] temp = numbers[i].split("[+]");
            int value = 0;
            for(int j = 0; j < temp.length; j++){
                value+= Integer.parseInt(temp[j]);
            }

            if (i  == 0)
                answer += value;
            else
                answer -= value;
        }
        System.out.println(answer);
    }
}
