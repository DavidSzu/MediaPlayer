package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.Mainframe;
import main.Main;

public class Listener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		Mainframe mf = Main.getMf();
		
		
		if(source == mf.getBtnStartStop() )
		{
			
		}
	}
}
