import java.util.HashMap;

public class 의상 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
        }

        int result = 1;

        for (String str : hm.keySet()) {
            result *= hm.get(str) + 1;
        }

        result -= 1;

        return result;


    }
}
