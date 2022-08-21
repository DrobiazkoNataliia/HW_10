import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/file.txt"))) {
            String line;
            String str = null;

            ArrayList<String> array = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                str = new String(line);
                array.add(str);
            }

            Pattern p = Pattern.compile("(\\(\\d{3}\\)\\s\\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4})");
            boolean found = false;
            for (String s : array) {
                if (p.matcher(s).find()) {
                    found = true;
                    System.out.println(s);
                }
            }
        }
    }
}




