import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) throws IOException {
        
        ServerSocket server = new ServerSocket(30333);

        Socket socket = server.accept();
        System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

        BufferedReader reader = new BufferedReader( new InputStreamReader(socket.getInputStream()) );
        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()) );
        String line;

        while (true) {
        line = reader.readLine();
        if ("close".equals(line)) {
            break;
        }
        System.out.println("Client sent: " + line);

        writer.write(line);
        writer.write(" - accepted\n");
        writer.flush();
        }

        System.out.println("Client closed connection.");

    }
}
