import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("./src/main/resources/file.txt");
        InputStreamReader input = new InputStreamReader(fileInputStream);
        BufferedReader br = new BufferedReader(input);
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            line = br.readLine();
        }

        Pattern pattern1 = Pattern.compile("(\\(\\d{3}\\)\\s\\d{3}-\\d{4})");
        Pattern pattern2 = Pattern.compile("(\\d{3}-\\d{3}-\\d{4})");
        List<Pattern> patterns = new ArrayList<>();
        patterns.add(pattern1);
        patterns.add(pattern2);
        for (Pattern pattern: patterns) {
            Matcher matcher = pattern.matcher(sb);
            if (matcher.find()) {
                System.out.println(matcher.group(0));
            }
        }

        fileInputStream.close();
        input.close();
        br.close();
    }
}





