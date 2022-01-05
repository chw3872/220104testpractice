import java.util.*;

public class UnCompletePlayer {
    public static void main(String[] args) {
        String[] arr1 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] arr2 = {"josipa", "filipa", "marina", "nikola"};

        String answer = solution(arr1, arr2);
        System.out.println(answer);
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < participant.length; i++) {
            if(hashMap.get(participant[i]) == null)
                hashMap.put(participant[i], 0);
            else
                hashMap.replace(participant[i], hashMap.get(participant[i]) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            if(hashMap.get(completion[i]) != null)
            {
                if(hashMap.get(completion[i]) == 0)
                    hashMap.remove(completion[i]);
                else
                    hashMap.replace(completion[i], hashMap.get(completion[i])-1);
            }
        }

        Collection<String> val =  hashMap.keySet();
        for (String str : val)
        {
            answer = str;
        }
        return answer;
    }
}
