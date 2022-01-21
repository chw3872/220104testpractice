public class Class101 {
    public static void main(String[] args) {
        int[] a = {2, 1, 1, 1, 2};
        String[] b = {"", "PP", "PP", "GM", ""};

        Solution s = new Solution();
        System.out.println(s.solution(a,b));
    }
    // you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

   public static class Solution {
        public int solution(int[] D, String[] T) {
            // write your code in Java SE 11
            int[][] trash = new int[D.length][3];
            for(int i = 0; i < T.length; i++){
                for(int j = 0; j < T[i].length(); j++){
                    if(T[i].charAt(j) == 'P'){
                        trash[i][0]++;
                    }
                    else if(T[i].charAt(j) == 'G'){
                        trash[i][1]++;
                    }
                    else {
                        trash[i][2]++;
                    }
                }
            }
            int totalTimeP = 0;
            int totalTimeG = 0;
            int totalTimeM = 0;
            int posP = -1;
            int posG = -1;
            int posM = -1;
            for(int i = 0; i < D.length; i++){
                if(trash[i][0] > 0){
                    for(int j = posP + 1; j <= i; j++){
                        totalTimeP += D[j];
                    }
                    posP = i;
                    totalTimeP += trash[i][0];
                }
                if(trash[i][1] > 0){
                    for(int j = posG + 1; j <= i; j++){
                        totalTimeG += D[j];
                    }
                    posG = i;
                    totalTimeG += trash[i][1];
                }
                if(trash[i][2] > 0){
                    for(int j = posM + 1; j <= i; j++){
                        totalTimeM += D[j];
                    }
                    posM = i;
                    totalTimeM += trash[i][2];
                }
            }

            for (int i =0; i <= posP; i++){
                totalTimeP += D[i];
            }
            for(int i = 0; i <= posG; i++){
                totalTimeG += D[i];
            }
            for(int i = 0; i <= posM; i++){
                totalTimeM += D[i];
            }

            return Math.max(totalTimeG, Math.max(totalTimeM, totalTimeP));
        }
    }

}
