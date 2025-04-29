import java.io.*;
import java.util.*;
public class RuleEngine {
    private static Set<String> blacklistedIPs = new HashSet<>();

    static {
        loadBlacklist();
    }

    public static void loadBlacklist() {
        try (BufferedReader br = new BufferedReader(new FileReader("config/blacklist.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                blacklistedIPs.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading blacklist file.");
            e.printStackTrace();
        }
    }

    public static boolean isBlocked(String ip) {
        return blacklistedIPs.contains(ip);
    }
}