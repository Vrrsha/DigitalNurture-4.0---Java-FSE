
// TCP Server
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");
        Socket socket = serverSocket.accept();
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = input.readLine()) != null) {
            System.out.println("Client: " + line);
            System.out.print("Server: ");
            output.println(console.readLine());
        }
        socket.close();
        serverSocket.close();
    }
}

// TCP Client
import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true) {
            System.out.print("Client: ");
            output.println(console.readLine());
            line = input.readLine();
            if (line == null) break;
            System.out.println("Server: " + line);
        }
        socket.close();
    }
}
