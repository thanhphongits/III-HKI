/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Thanh Phong
 */
public class Client_Demo {
    private Socket socket = null; 
	BufferedWriter out = null;
	BufferedReader in = null;
	BufferedReader stdIn = null; 

	public Client_Demo(String address, int port) throws UnknownHostException, IOException
	{ 
		socket = new Socket(address, port); 
		System.out.println("Connected"); 
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		stdIn = new BufferedReader(new InputStreamReader(System.in));

		String line = ""; 
		while (!line.equals("Over")) 
		{ 
			line = stdIn.readLine();
			System.out.println("Client sent: " + line);
			out.write(line);
			out.newLine();
			out.flush();
		} 
		in.close(); 
		out.close(); 
		socket.close(); 
	} 

	public static void main(String args[]) throws UnknownHostException, IOException 
	{ 
		Client_Demo client = new Client_Demo("127.0.0.1", 5000); 
	} 
    
}
