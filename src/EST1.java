public class EST1 {
    public static void main(String[] args) {
        String[] scores = {"AAFAFA", "FEECAA", "FABBCB", "CBEDEE", "CCCCCC"};
        System.out.println(new Solution().solution(scores));
    }

    public static class Solution {
        public int solution(String[] scores) {
            //입력받기
            int[][] iscores = new int[scores.length][6];
            for (int i = 0; i < scores.length; i++) {
                for (int j = 0; j < scores[0].length(); j++) {
                    if (scores[i].charAt(j) == 'A')
                        iscores[i][5]++;
                    else if (scores[i].charAt(j) == 'B')
                        iscores[i][4]++;
                    else if (scores[i].charAt(j) == 'C')
                        iscores[i][3]++;
                    else if (scores[i].charAt(j) == 'D')
                        iscores[i][2]++;
                    else if (scores[i].charAt(j) == 'E')
                        iscores[i][1]++;
                    else
                        iscores[i][0]++;
                }
            }

            //점수 변환
            int answer = 0;
            for (int i = 0; i < iscores.length; i++) {
                if (iscores[i][0] >= 2)
                    continue;
                if (iscores[i][5] >= 2) {
                    answer++;
                    continue;
                }
                //최고점 제외
                for (int j = 5; j >= 0; j--) {
                    if (iscores[i][j] != 0) {
                        iscores[i][j]--;
                        break;
                    }
                }
                //최저점 제외
                for (int j = 0; j <= 5; j++) {
                    if (iscores[i][j] != 0) {
                        iscores[i][j]--;
                        break;
                    }
                }
                double sum = 0;
                for(int j = 0; j <=5; j++){
                    sum += (j*iscores[i][j]);
                }
                if(sum / (double)(scores[0].length() - 2) >= 3)
                    answer++;
            }
            return answer;
        }
    }
}
