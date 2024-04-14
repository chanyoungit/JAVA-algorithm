import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NOTE {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "사과");
        hm.put(2, "바나나");
        hm.put(3, "포도");

        for (Map.Entry<Integer, String> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Iterator<Integer> keys = hm.keySet().iterator();
        while(keys.hasNext()) {
            int key = keys.next();
            hm.put(key, hm.getOrDefault(key, "0") + 1);
        }
    }
}