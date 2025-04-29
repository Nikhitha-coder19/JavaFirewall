import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FirewallEngine {
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(9090)) {
            System.out.println("Listening on port 9090...");

            while (true) {
                Socket client = serverSocket.accept();
                String ip = client.getInetAddress().toString();

                if (RuleEngine.isBlocked(ip)) {
                    System.out.println("Blocked IP: " + ip);
                    Logger.logBlocked(ip);
                    client.close();
                } else {
                    System.out.println("Allowed IP: " + ip);
                    // You can handle allowed connections here
                }
            }

        } catch (IOException e) {
            System.out.println("Error starting firewall.");
            e.printStackTrace();
        }
    }
}