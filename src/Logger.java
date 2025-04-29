import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
public class Logger {
    public static void logBlocked(String ip) {
        try (FileWriter writer = new FileWriter("blocked_log.txt", true)) {
            writer.write("Blocked IP: " + ip + " at " + LocalDateTime.now() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
