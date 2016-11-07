package socketprograming.udp.server;

import java.io.*;
import java.net.*;

public class Server {
	
	public static void main(String [] args) throws Exception{
		startServer();
	}

	public static void startServer() throws Exception {
		DatagramSocket serverSocket = new DatagramSocket(9876);
		
		byte[] receiveData = new byte[1024];
		
		byte[] sendData = new byte[1024];
		
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			
			serverSocket.receive(receivePacket);
			
			String sentence = new String(receivePacket.getData());
			
			InetAddress IPAddress = receivePacket.getAddress();
			
			int port = receivePacket.getPort();
			
			String modifiedSetence = "Hello "+sentence;
			
			sendData = modifiedSetence.getBytes();
			
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			
			serverSocket.send(sendPacket);
		}
	}
}
