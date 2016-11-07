package socketprograming.tcp.server;

import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) throws IOException {
		startServer();
	}

	public static void startServer() throws IOException {
		String clientSentence;

		String modifiedSentence;
		@SuppressWarnings("resource")
		ServerSocket welcomeSocket = new ServerSocket(6789);

		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
			clientSentence = inFromClient.readLine();
			
			modifiedSentence= "Hello "+ clientSentence + '\n';
			
			outToClient.writeBytes(modifiedSentence);
		}

	}
}
