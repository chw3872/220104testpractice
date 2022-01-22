import java.util.LinkedList;
import java.util.Queue;

public class EST2 {
    public static void main(String[] args) {
        int[][] needs = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new Solution().solution(needs, 2));
    }

    public static class Solution {

        public static int solution(int[][] needs, int r) {
            int answer = 0;

            //조합으로 부품 뽑아보기
            int[] arr = new int[needs[0].length];
            for (int i = 0; i < needs[0].length; i++) {
                arr[i] = 1;
            }
            boolean[] visited = new boolean[needs[0].length];
            combi = new LinkedList<>();
            rnumber = r;
            comb1(arr, visited, 0, needs[0].length, r);

            for (int[] lists : combi) {
                int cnt = 0;
                for (int i = 0; i < needs.length; i++) {
                    LinkedList<Integer> partlist = new LinkedList<>();
                    for (int j = 0; j < needs[i].length; j++) {
                        if (needs[i][j] == 1)
                            partlist.add(j);
                    }
                    for (int j = 0; j < lists.length; j++) {
                        for(int k = 0; k < partlist.size(); k++){
                            if(partlist.get(k) == lists[j])
                                partlist.remove(k);
                        }
                    }
                    if (partlist.isEmpty())
                        cnt++;
                }
                if (cnt > answer)
                    answer = cnt;

            }
            return answer;
        }
    }

    public static Queue<int[]> combi;
    public static int rnumber;

    public static void comb1(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int[] answer = new int[rnumber];
            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    answer[idx] = i;
                    idx++;
                }
            }
            combi.add(answer);
            return;
        } else {
            for (int i = start; i < n; i++) {
                visited[i] = true;
                comb1(arr, visited, i + 1, n, r - 1);
                visited[i] = false;
            }
        }
    }
}
