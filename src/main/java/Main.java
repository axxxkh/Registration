import Actions.Registration;
import DataIO.User;
import DataIO.UserReader;
import DataIO.UserWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        User anotherUser = User.create("{\"login\":\"Monica\",\"password\":[\"\u0091\",\"¤\",\"\u009A\",\"\u0098\",\"\u009B\",\"§\",\"\u009C\",\"j\",\"\u0097\",\"i\"],\"birthday\":{\"year\":2022,\"month\":1,\"day\":27},\"secretQuestion\":\"question\",\"secretAnswer\":\"sdfsfs\",\"favoriteColour\":\"red\"}");
        User someUser = User.create("{\"login\":\"John\",\"password\":[\"\u0091\",\"¤\",\"\u009A\",\"\u0098\",\"\u009B\",\"§\",\"\u009C\",\"j\",\"\u0097\",\"i\"],\"birthday\":{\"year\":2022,\"month\":1,\"day\":27},\"secretQuestion\":\"question\",\"secretAnswer\":\"sdfsfs\",\"favoriteColour\":\"red\"}");
        Registration.start();
    }
}
