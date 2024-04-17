import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> num = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            if (!num.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
            } else {
                num.put(genres[i], num.get(genres[i]) + plays[i]);
                music.get(genres[i]).put(i, plays[i]);
            }
        }

        ArrayList<String> numKey = new ArrayList(num.keySet());
        Collections.sort(numKey, (s1, s2) -> num.get(s2) - num.get(s1));

        for (String key : numKey) {
            HashMap<Integer, Integer> map = music.get(key);
            ArrayList<Integer> al = new ArrayList(map.keySet());

            Collections.sort(al, (s1, s2) -> map.get(s2) - map.get(s1));

            answer.add(al.get(0));
            if (al.size() > 1) {
                answer.add(al.get(1));
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
