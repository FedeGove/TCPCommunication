package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

            boolean continua = true;
            while (continua) {
            
                System.out.print("Scrivi un messaggio: ");
                String messaggio = tastiera.readLine();
                printWriter.println(messaggio);

                String risposta = bufferedReader.readLine();
                System.out.println("Il Server ha risposto: " + risposta);

                System.out.print("Vuoi mandare un altro messaggio? (si/no): ");
                String scelta = tastiera.readLine();
                printWriter.println(scelta);  

                String conferma = bufferedReader.readLine();
                if (conferma == null || conferma.equals("STOP")) {
                    continua = false;
                }
            }

            System.out.println("Chat terminata.");
            socket.close();

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}