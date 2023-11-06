package pro.java.hw21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public BufferedReader in;
    public PrintStream out;

    public Client(String serverAddress, int serverPort) {
        try {
            Socket socket = new Socket(serverAddress, serverPort);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream(), true);

            // Create a separate thread to listen for and display messages from the server.
            Thread receiveThread = new Thread(this::listenForMessages);
            receiveThread.start();

            // Read input from the user and send messages to the server.
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String userInput = scanner.nextLine();
                sendMessage(userInput);

                if (userInput.equals("-exit")) {
                    System.err.println("You've been disconnected from the server");

                    // Close the connection and exit the application when the user sends the exit command.
                    socket.close();
                    System.exit(0);
                }
                if (userInput.startsWith("-file")) {
                    String[] parts = userInput.split(" ");
                    if (parts.length >= 2) {
                        String filePath = parts[1];
                        File file = new File(filePath);

                        if (file.exists()) {
                            try (FileInputStream fileInputStream = new FileInputStream(file);
                                 OutputStream outputStream = socket.getOutputStream()) {
                                byte[] buffer = new byte[1024];
                                int bytesRead;
                                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                                    outputStream.write(buffer, 0, bytesRead);
                                }
                                System.out.println("File " + file.getName() + " has been sent to the server");
                                socket.close();
                                System.exit(0);
                            } catch (IOException e) {
                                System.err.println("Error occurred while sending file to the server" + e.getMessage());
                            }
                        } else {
                            System.err.println("File not found: " + filePath);
                        }
                    }
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + serverAddress);
        } catch (SocketException e) {
            System.err.println("Socket was closed by user" + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error occurred while connecting to the server" + e.getMessage());
        }
    }

    public void listenForMessages() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Server: " + message);
            }
        } catch (IOException e) {
            System.err.println("Error occurred while listening for messages from the server" + e.getMessage());
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
