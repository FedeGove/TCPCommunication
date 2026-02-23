package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        int port = 12345;

        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server in ascolto sulla porta " + port);

            Socket clientSocket = server.accept();
            System.out.println("Client connesso");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(), true);

            boolean continua = true;
            while (continua) {
                
                String messaggio = bufferedReader.readLine();
                if (messaggio == null) break;
                System.out.println("Il client ha scritto: " + messaggio);

                
                printWriter.println("Ho ricevuto il tuo messaggio: \"" + messaggio + "\"");

                
                String risposta = bufferedReader.readLine();
                if (risposta == null || risposta.equalsIgnoreCase("no")) {
                    continua = false;
                    printWriter.println("STOP");
                } else {
                    printWriter.println("OK");
                }
            }

            System.out.println("Connessione terminata.");
            clientSocket.close();
            server.close();

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}