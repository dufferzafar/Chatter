import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.net.*;
import java.io.*;

public class GUI
{
	JFrame fr;
	JTextField tf;
	String text="";
	JEditorPane editor;
	String input;
	JScrollPane scrollPane;

	public GUI(final String username)
	{
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception e) {
		}

		fr = new JFrame(username);
		fr.setLayout(null);

		editor = new JEditorPane("text/html",text);
		editor.setEditable(false);
		fr.add(editor);

		tf = new JTextField();
		tf.setBounds(0,332,124,30);
		fr.add(tf);

		scrollPane = new JScrollPane(editor);
		scrollPane.setBounds(0,0,185,330);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		fr.add(scrollPane);

		fr.setSize(200,400);
		fr.setVisible(true);

		tf.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					input = tf.getText();
					if(!input.equals(""))
					{
						ClsClientChat.printmsg("<strong>" + username + ": </strong>" +input);
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

	public void printanswer(String txt)
	{
		editor.setText(text + "<br>" + txt );
	}
}
