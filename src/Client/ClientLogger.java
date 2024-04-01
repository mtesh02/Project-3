
//Copyright(c))2023, Munywoki D. Kiteme < munywoki1735 at gmail dot com >
//All rights reserved.

package Client;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientLogger {
    private static final String LOG_FILE = "client_log.txt";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        String formattedTime = DATE_TIME_FORMATTER.format(currentTime);

        String logEntry = formattedTime + " | " + message;

        try (FileWriter fileWriter = new FileWriter(LOG_FILE, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(logEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
