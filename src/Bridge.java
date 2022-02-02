public class Bridge {
    public static void main(String[] args) {
        Solutions solution = new Solutions();
        int[] truck_weights = new int[]{7,4,5,6};
        solution.solution(2	,10, truck_weights);
    }
}
class Solutions {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int[] truck_times = new int[truck_weights.length];
        for(int i = 0; i < truck_weights.length; i++)
            truck_times[i] = bridge_length;

        return answer;
    }
}