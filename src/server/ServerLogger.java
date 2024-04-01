
//Copyright(c))2023, Munywoki D. Kiteme < munywoki1735 at gmail dot com >
//All rights reserved.

package server;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerLogger {
    private static final String LOG_FILE_PATH = "server.log";

    public static void log(String message) {
        String formattedMessage = getTimestamp() + " - " + message;
        System.out.println(formattedMessage); // Print to console

        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.println(formattedMessage); // Append to log file
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    private static String getTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
