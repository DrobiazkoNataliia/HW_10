import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;


public class Part2 {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("./src/main/resources/File2.txt"))) {
            String line;
            String str = null;
            User user = null;

            ArrayList<User> user2 = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                str = new String(line);

                if (!str.contains("name age")) {
                    String[] str2 = str.split(" ");
                    user = new User(str2[0], Integer.valueOf(str2[1]));
                    user2.add(user);
                }
            }

            System.out.println(user2);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(user2);

            System.out.println(json);

            File file = new File("./src/main/resources/user.json");
            //try-with-resources
            try (FileWriter writer = new FileWriter(file))
            {
                String text = json;
                writer.write(text);
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


class User{
    private String name;
    private int age;

    User(String name, int age){
        this.name = name;
        this.age = age;
    }
    public User()
    {

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return getName() + " " + getAge();
    }
}