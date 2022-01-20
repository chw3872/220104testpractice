import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Q1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] numbers = new int[str.length()];
        for(int i = 0; i < str.length(); i++){
            numbers[i] = Character.getNumericValue(str.charAt(i));
        }
        Arrays.sort(numbers);
        for(int i = numbers.length - 1; i >= 0; i--){
            System.out.print(numbers[i]);
        }
        System.out.println();
    }
}
