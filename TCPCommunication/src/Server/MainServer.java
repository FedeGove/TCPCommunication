package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args){
        
        int port = 12345;

        try  {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            
            Socket clientSocket = server.accept();
            System.out.println("Client connected");

            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            clientSocket.close();
            server.close();

        } catch (IOException e) {
            System.err.println("Could not listen on port " + port);
        }


        
    }
}