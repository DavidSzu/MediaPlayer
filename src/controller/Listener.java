package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import gui.Mainframe;
import main.Main;
import model.PlayerFunctions;

public class Listener implements ActionListener
{

	Mainframe mf = Main.getMf();
	final JFileChooser fc = new JFileChooser();
	PlayerFunctions pf = new PlayerFunctions();
	public String fileLocation;

	public void actionPerformed(ActionEvent e)
	{

		Object source = e.getSource();
		Mainframe mf = Main.getMf();

		if (source == mf.getMntmOpen())
		{
			int returnVal = fc.showOpenDialog(null);

			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				final File[] dir = fc.getSelectedFiles();
				File file = fc.getSelectedFile();
				System.out.println("Opening: " + file.getName() + ".");
			}
		}

		if (source == mf.getBtnStartPause())
		{
			
			if(pf.getIsplaying() == false)
			{
				pf.playAudio("D:\\Music\\Amon Amarth\\Fate Of Norns\\Arson.mp3");
				mf.getBtnStartPause().setText("Pause");
				pf.setIsplaying(true);
			}
			else
			{
				pf.pauseAudio();
				mf.getBtnStartPause().setText("Start");
				pf.setIsplaying(false);
			}
		}
	}
}
