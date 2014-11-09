import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.net.*;
import java.io.*;

public class GUI
{
	JEditorPane editor;
	JFrame fr;
	JScrollPane scrollPane;
	JTextField tf;

	String input = "";
	String them = "";
	String text = "";

	public GUI(final String username)
	{
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception e) {
		}

		fr = new JFrame(username);
		fr.setLayout(null);
		fr.setResizable(false);
		fr.setSize(200,400);

		editor = new JEditorPane("text/html", text);
		editor.setEditable(false);
		fr.add(editor);

		scrollPane = new JScrollPane(editor);
		scrollPane.setBounds(0,0,200,335);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		fr.add(scrollPane);

		tf = new JTextField();
		tf.setBounds(0,340,200,30);
		fr.add(tf);

		// fr.setAlwaysOnTop(true);
		// fr.setLocationRelativeTo(null);
		fr.setVisible(true);
        tf.requestFocusInWindow();

		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					input = tf.getText();
					if(!input.equals(""))
					{
						ClsClientChat.printmsg("<strong>" + username + ": </strong>" + input);
						input = "<strong>You: </strong>" + input;
						text = text + "<br>" + input;
						editor.setText(text);
						tf.setText("");
					}
				}
            }
        });

		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void printanswer(String recieved)
	{
		them = recieved;
		text = text + "<br>" + them ;
		editor.setText(text);
	}
}
