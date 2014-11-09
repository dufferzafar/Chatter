import java.net.*;
import java.util.*;
import java.io.*;

class ClsClientChat extends Thread
{
	static DataInputStream objDIS; //For sending chats
	static DataOutputStream objDOS; //For recieving chats

	public void run()
	{
		try
		{
			Socket objSocket = new Socket("127.0.0.1",1500); //Send request to server at given address:port
			System.out.println("Connection established");

			objDIS = new DataInputStream(objSocket.getInputStream());  //Input
			objDOS = new DataOutputStream(objSocket.getOutputStream()); //Ouput

			String name = JOptionPane.showInputDialog("Please enter your name:");

			//Create GUI for client.
			GUI gui = new GUI(name);

			while(true)
			{
			    // System.out.println("Control in while client");
				String serverMsg = objDIS.readUTF();  //Read message.
				gui.printanswer(serverMsg); //Display message on GUI
			}
		}
		catch(Exception e)
		{
			System.out.println("Server not found.");
		}
	}

	static void printmsg(String text)
	{
		try
		{
			objDOS.writeUTF(text);  //Send message to server when recieved by GUI
		}
		catch (Exception e)
		{}
	}
}

