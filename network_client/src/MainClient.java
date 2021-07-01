import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket socket = new Socket("localhost", 30333);

        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()) );
        BufferedReader reader = new BufferedReader( new InputStreamReader(socket.getInputStream()) );
        String line;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            line = scanner.nextLine();
            writer.write(line);
            writer.write("\n");
            writer.flush();

            if ("close".equals(line)) {
                break;
            }

            line = reader.readLine();
            System.out.println("Server sent: " + line);
        }

        System.out.println("Client closed connection.");

    }
}
