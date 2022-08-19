import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Part3 {

        public static void main(String[] args) throws IOException {

            File f = new File("./src/main/resources/word.txt");

            final int length = (int) f.length();

            if (length != 0) {

                char[] chr = new char[length];

                InputStreamReader isr = new InputStreamReader(new FileInputStream(f),"CP1251");

                final int read = isr.read(chr);

                String str = new String(chr, 0, read);

                str = str.replaceAll("\\W", " ");

                Map<String, Integer> map = new HashMap<>();
                for(String s: str.split(" ")) {
                    if(map.containsKey(s)) {
                        map.put(s, map.get(s) + 1);
                    }
                    else {
                        map.put(s, 1);
                    }
                }
                map.remove("");

                map.entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                        .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
            }
        }
}
