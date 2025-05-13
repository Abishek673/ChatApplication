package com.example.com;
import java.io.*;
import java.net.*;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 1234);
			System.out.println("Connected to server!");
			
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			String msgFromServer, msgToServer;
			
			while (true) {
				System.out.print("You: ");
				msgToServer = keyboard.readLine();
				output.println(msgToServer);
				if (msgToServer.equalsIgnoreCase("exit")) break;
				msgFromServer = input.readLine();
				System.out.println("Server: " + msgFromServer);
			}
			
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
