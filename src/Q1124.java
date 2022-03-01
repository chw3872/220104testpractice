import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1124 {
    public static boolean[] primeNum = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        getPrime();

        int answer = 0;
        for(int i = a; i <= b; i++){
            if(!primeNum[primeFactor(i)])
                answer++;
        }
        System.out.println(answer);
    }
    public static void getPrime(){
        primeNum[0] = true;
        primeNum[1] = true;
        for(int i = 2; i*i <= 100000; i++){
            if(!primeNum[i]){
                for(int j = 2; i*j <= 100000; j++){
                    primeNum[i*j] = true;
                }
            }
        }
    }
    public static int primeFactor(int a){
        int answer = 0;
        while (a > 1){
            for(int i = 2; i <= a; i++){
                if(!primeNum[i] && (a % i == 0)){
                    answer++;
                    a /= i;
                }
            }
        }
        return answer;
    }
}
