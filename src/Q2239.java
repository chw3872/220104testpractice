import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Q2239 {
    public static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                map[i][j] = Character.getNumericValue(arr[j]);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0)
                    sudoku(i, j);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> findList(int x, int y) {
        //행 확인
        boolean[] check = new boolean[10];
        for (int k = 0; k < 9; k++)
            if (map[x][k] != 0)
                check[map[x][k]] = true;
        //열 확인
        for (int k = 0; k < 9; k++)
            if (map[k][y] != 0)
                check[map[k][y]] = true;
        //3*3확인
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (map[x / 3 + k][y / 3 + l] != 0)
                    check[map[x / 3 + k][y / 3 + l]] = true;
            }
        }
        ArrayList<Integer> numList = new ArrayList<>();
        for (int k = 1; k <= 9; k++) {
            if (!check[k]) {
                numList.add(k);
            }
        }
        return numList;
    }

    public static boolean sudoku(int x, int y) {
        ArrayList<Integer> numList = findList(x, y);
        if (numList.size() == 0)
            return false;
        for (int a : numList) {
            map[x][y] = a;
            int tx = x, ty = y;
            if (y + 1 < 9){
                ty++;
            }
            else{
                tx++;
                ty = 0;
            }
            if (!sudoku(tx, ty))
                continue;
            else
                break;
        }
        return true;
    }
}
