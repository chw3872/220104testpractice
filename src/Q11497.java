import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] trees = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                trees[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(trees);

            int maxVal = 0;
            int[] left = new int[n / 2 + 1];
            int leftIndex = 0;
            int[] right = new int[n / 2 + 1];
            int rightIndex = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    left[0] = trees[i];
                    right[0] = trees[i];
                    leftIndex++;
                    rightIndex++;
                } else if (i % 2 == 0) {
                    left[leftIndex] = trees[i];
                    if (left[leftIndex] - left[leftIndex - 1] > maxVal)
                        maxVal = left[leftIndex] - left[leftIndex - 1];
                    leftIndex++;
                } else if (i % 2 == 1) {
                    right[rightIndex] = trees[i];
                    if (right[rightIndex] - right[rightIndex - 1] > maxVal)
                        maxVal = right[rightIndex] - right[rightIndex - 1];
                    // maxVal = Math.max(maxVal, right[rightIndex] - right[rightIndex - 1];
                    rightIndex++;
                }
            }
            if (left[leftIndex - 1] > right[rightIndex - 1] && left[leftIndex - 1] - right[rightIndex - 1] > maxVal)
                maxVal = left[leftIndex - 1] - right[rightIndex - 1];
            else if (right[rightIndex - 1] > left[leftIndex - 1] && right[rightIndex - 1] - left[leftIndex - 1] > maxVal)
                maxVal = right[rightIndex - 1] - left[leftIndex - 1];

            System.out.println(maxVal);
        }
    }
}
