package DataIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class LogWriter {
    public void writeLog(String s) throws IOException {
        String filePath = "/logs/" + LocalDate.now() + ".txt";
        FileWriter writer = new FileWriter(filePath, new File(filePath).isFile());

        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.println(LocalDate.now() + " " + s);


    }
}
