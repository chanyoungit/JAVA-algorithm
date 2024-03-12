import java.util.HashMap;
import java.util.Map.Entry;

public class NOTE02 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1, 10);
        hm.put(2, 20);
        if (hm.get(3) == null) hm.put(3, 30);
        for (Entry<Integer, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
        for (Integer i : hm.keySet()){
            System.out.println(i+hm.get(i));
        }
    }
}
