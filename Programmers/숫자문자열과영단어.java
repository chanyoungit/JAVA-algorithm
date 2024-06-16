import java.util.HashMap;
import java.util.Map;

public class 숫자문자열과영단어 {
    public int solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        String str = "";
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char sa = s.charAt(i);

            if (sa >= '0' && sa <= '9') {
                answer += sa;
            } else {
                str += sa;
                if (map.containsKey(str)) {
                    answer += String.valueOf(map.get(str));
                    str = "";
                }
            }
        }

        return Integer.valueOf(answer);
    }
}
