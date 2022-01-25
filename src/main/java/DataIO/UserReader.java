package DataIO;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class UserReader {
    public User read(String login) throws IOException {
//
//        FileReader fileReader;
//
//        try {
//            fileReader = new FileReader("src/UserDB/" + login + ".txt");
//        } catch (NullPointerException e) {
//            System.out.println("No such user");
//            return null;
//        }
//
//        BufferedReader reader = new BufferedReader(fileReader);
//        String data = null;
//        User user = new User();
//        while ((data = reader.readLine()) != null) {
//            user.setLogin(data);
//            user.setPassword(pwdCoder(reader.readLine().toCharArray(), user.getLogin()));
//            user.setBirthday(LocalDate.parse(reader.readLine()));
//            user.setSecretQuestion(reader.readLine());
//            user.setSecretAnswer(reader.readLine());
//            user.setFavoriteColour(reader.readLine());
//        }
//        reader.close();
//        System.out.println(user.getLogin());
//        System.out.println(user.getPassword());
//        System.out.println(user.getBirthday());
//        System.out.println(user.getSecretQuestion());
//        System.out.println(user.getSecretAnswer());
//        System.out.println(user.getFavoriteColour());
//        return user;
        File file = new File("src/main/java/UserDB/" + login.toLowerCase(Locale.ROOT) + ".json");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int i;
        StringBuilder sb = new StringBuilder();
        while ((i = fileReader.read()) != -1) {
            sb.append((char) i);
        }

        Gson gson = new Gson();
        User user = gson.fromJson(sb.toString(), User.class);
        user.setPassword(pwdCoder(user.getPassword(), user.getLogin()));
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    private char[] pwdCoder(char[] pwd, String login) {
        String codeString = "Еней був парубок моторний\n" +
                "І хлопець хоть куди козак,\n" +
                "Удавсь на всеє зле проворний,\n" +
                "Завзятійший од всіх бурлак.\n" +
                "Но греки, як спаливши Трою,\n" +
                "Зробили з неї скирту гною,\n" +
                "Він, взявши торбу, тягу дав;\n" +
                "Забравши деяких троянців,\n" +
                "Осмалених, як гиря, ланців,\n" +
                "П’ятами з Трої накивав.";
        char[] hash = String.valueOf(login.hashCode()+codeString).toCharArray();
        char[] decrypted = new char[pwd.length];
        for (int i = 0; i < pwd.length; i++) {
//            if (i < hash.length) {
                decrypted[i] = (char) (pwd[i] - hash[i]);
//            } else {
//                decrypted[i] = pwd[i];
//            }
        }
        return decrypted;
    }
}
