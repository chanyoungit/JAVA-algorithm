import java.util.Arrays;
import java.util.HashMap;

public class 전화번호목록 {
    // 배열 풀이
    public boolean solution1(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

    //HashMap 풀이
    public boolean solution2(String[] phone_book) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            hm.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (hm.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
