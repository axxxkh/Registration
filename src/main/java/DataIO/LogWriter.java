package DataIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LogWriter {
    public static void writeLog(String s) {
        String filePath = "src/main/java/logs/" + LocalDate.now() + ".txt";
        FileWriter writer = null;
        try {
            writer = new FileWriter(filePath, new File(filePath).isFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println(LocalDateTime.now() + " " + s);
        printWriter.flush();
        printWriter.close();
    }
}
