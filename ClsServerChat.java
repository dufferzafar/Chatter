import java.net.*;
import java.util.*;
import java.io.*;

class ClsServerChat extends Thread
{
	static DataInputStream objDIS;
	static DataOutputStream objDOS;

	int i=0;

	public void run()
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(1500);
			System.out.println("Server connected");

			while(true)
			{
			  Socket clientSocket = serverSocket.accept();
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
