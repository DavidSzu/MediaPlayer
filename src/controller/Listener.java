package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import gui.Mainframe;
import main.Main;

public class Listener implements ActionListener
{
	
	final JFileChooser fc = new JFileChooser();

	
	public void actionPerformed(ActionEvent e)
	{
		
		Object source = e.getSource();
		Mainframe mf = Main.getMf();
		
		
		if(source == mf.getMntmOpen() )
		{
			int returnVal =  fc.showOpenDialog(null);
			
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				final File[] dir = fc.getSelectedFiles();
				File file = fc.getSelectedFile();
				System.out.println("Opening: " + dir.length + ".");
			}
		}
	}
}
