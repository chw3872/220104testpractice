import java.util.*;

public class EST3 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] record = {"id=1 sit k=1","id=2 sit k=3","id=3 sit k=2","id=2 leave","id=4 sit k=4","id=5 sit k=2"};
        long[][] answer = s.solution(record);
    }
    public static class Solution {
        public static int MAXSEAT = 100000000;
        public static long[][] solution(String[] record) {
            int[] seats = new int[MAXSEAT];
            int[] ids = new int[1001];
            int[] nb= new int[1001];
            int cnt = 0;
            for (int i = 0; i < record.length; i++) {
                String[] move = record[i].split(" ");
                if(move.length == 3){
                    String[] findID = move[0].split("=");
                    int id = Integer.parseInt(findID[1]);
                    String[] findSeats = move[2].split("=");
                    int blanks = Integer.parseInt(findSeats[1]);
                    nb[id] = blanks;
                    int need = 2*blanks + 1;
                    for(int j = 0; j < MAXSEAT; j++){
                        boolean canSeat = true;
                        for(int k = 0; k < need; k++){
                            if(seats[j + k] > 0){
                                canSeat = false;
                                break;
                            }
                        }
                        if(canSeat){
                            for(int k = 0; k < need; k++)
                                seats[j + k] -= id;
                            seats[j + blanks] = id;
                            ids[id] = j + blanks;
                            break;
                        }
                    }
                    cnt++;
                }
                else{
                    String[] findID = move[0].split("=");
                    int id = Integer.parseInt(findID[1]);
                    for(int j = ids[id] - nb[id]; j <= ids[id] + nb[id]; j++)
                        seats[j] += id;
                    seats[ids[id]] = seats[ids[id] - 1];
                    ids[id] = 0;
                    cnt--;
                }
            }
            long[][] answer = new long[cnt][2];
            int idx = 0;
            for(int i = 1; i < ids.length; i++){
                if(ids[i] != 0)
                {
                    long[] temp = {i, ids[i]};
                    answer[idx] = temp;
                    idx++;
                }
                if(idx == cnt)
                    break;
            }
            return answer;
        }
    }
}
