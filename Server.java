package com.example.com;
import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(1234);
			System.out.println("Server started. Waiting for client...");
			Socket socket = serverSocket.accept();
			System.out.println("Client connected");
			
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			String msgFromClient, msgToClient;
			
			while (true) {
				msgFromClient = input.readLine();
				if (msgFromClient.equalsIgnoreCase("Exit")) break;
				System.out.println("Client: " + msgFromClient);
				System.out.print("You: ");
				msgToClient = keyboard.readLine();
				output.println(msgToClient);
			}
			
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
