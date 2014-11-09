import java.net.*;
import java.util.*;
import java.io.*;

class ClsServerChat extends Thread
{
	static DataInputStream objDIS; //For sending chats
	static DataOutputStream objDOS;  //For recieving chats

	int i=0;  //Identity tag

	public void run()
	{
		try
		{
			//InetAddress addname = InetAddress.getByName("192.168.1.95");
			ServerSocket objServerSocket = new ServerSocket(1500);
			System.out.println("Server connected");

			while(true)
			{
			  //System.out.println("Waiting for Client to Connect");
			  Socket clientSocket = objServerSocket.accept();
			  // System.out.println("Client connected" + client.getRemoteSocketAddress().toString());

			  ChatHandler clientHandler = new ChatHandler(clientSocket, i);
			  clientHandler.start();

			  i++;
		    }
		}
		catch(Exception e)
		{
		}
	}
}
