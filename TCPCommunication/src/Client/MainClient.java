package Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            socket.close();
        } catch (IOException e) {
            System.err.println("Could not connect to server");
        }
    }
}
