import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class NOTE {
    public static void main(String[] args) {
        String[] phone_book = {"123", "456", "789"};
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            hm.put(phone_book[i], i);
        }

        boolean bl = false;
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                System.out.println("j = " + j);
                System.out.println(phone_book[i].substring(0, j));
                if (hm.containsKey(phone_book[i].substring(0, j))) {
                    bl = true;
                    System.out.println("false");
                    break;
                }
            }
        }
        if (!bl) {
            System.out.println("true");
        }
    }
}