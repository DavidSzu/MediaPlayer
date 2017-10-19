package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.Mainframe;
import main.Main;
import model.AACPlayer;
import model.FileHandler;
import model.Setup;
import model.Setup.Repeatstate;

public class Listener implements ActionListener
{
	Mainframe mf = Main.getMf();
	final JFileChooser fc = new JFileChooser();
	FileHandler fileHandler = new FileHandler();
	List<File> filesListed;
	List<String> trackNameList;
	public String fileLocation;
	Path directoryName;
	FileFilter filter = new FileNameExtensionFilter("MP3 Files", "m4a", "mp3", "wav", "aac", "flac");
	private AACPlayer aacPlayer;
	private Setup setup = new Setup();


// ---------------------------------------------------

	public void actionPerformed(ActionEvent e)
	{

		Object source = e.getSource();
		Mainframe mf = Main.getMf();

// ---------------------------------------------------
		if (source == mf.getMenuItemOpen())
		{
			directoryName = fileHandler.chooseDirectory();

			filesListed = fileHandler.listf(directoryName.toString());
			trackNameList = fileHandler.listNames(directoryName.toString());
			aacPlayer = new AACPlayer(filesListed);
			mf.addMediaList(filesListed);
			
			Main.getProps().propertiesOut(trackNameList);
		}

// ---------------------------------------------------
		if (source == mf.getBtnStartPause())
		{
			if(!mf.getMediaList().isSelectionEmpty())
			{
				if (!aacPlayer.isPlaying() && (mf.getBtnStartPause().getText() == "Start"))
				{
					aacPlayer.play(mf.getMediaList().getSelectedIndex());
					mf.getBtnStartPause().setText("Pause");
				}
				else if (aacPlayer.isPlaying())
				{
					aacPlayer.pause();
					mf.getBtnStartPause().setText("Resume");
				}
				else if (!aacPlayer.isPlaying() && (mf.getBtnStartPause().getText() == "Resume"))
				{
					aacPlayer.resume();
					mf.getBtnStartPause().setText("Pause");
				}
			}
			else
			{
				if (!aacPlayer.isPlaying() && (mf.getBtnStartPause().getText() == "Start"))
				{
					aacPlayer.play(0);
					mf.getBtnStartPause().setText("Pause");
				}
				else if (aacPlayer.isPlaying())
				{
					aacPlayer.pause();
					mf.getBtnStartPause().setText("Resume");
				}
				else if (!aacPlayer.isPlaying() && (mf.getBtnStartPause().getText() == "Resume"))
				{
					aacPlayer.resume();
					mf.getBtnStartPause().setText("Pause");
				}
			}

		}
		
// ---------------------------------------------------
		if (source == mf.getBtnStop())
		{
			if (aacPlayer.isPlaying())
			{
				aacPlayer.stop();
				mf.getBtnStartPause().setText("Start");
			}
		}
		
// ---------------------------------------------------
		if (source == mf.getBtnShuffle())
		{
			if (mf.getBtnShuffle().getText() == "Enable Shuffle")
			{
			}
		}
		
// ---------------------------------------------------
		if (source == mf.getBtnRepeatloop())
		{
			setup.getRepstate();
			if (setup.getRepstate() == Repeatstate.REPEATLOOPOFF)
			{
				setup.setRepstate(Repeatstate.LISTLOOPON);
				mf.getBtnRepeatloop().setText("Loop on");
				aacPlayer.enableLoop();
			}
			else if (setup.getRepstate() == Repeatstate.LISTLOOPON)
			{
				setup.setRepstate(Repeatstate.REPEATTRACK);
				mf.getBtnRepeatloop().setText("Repeat on");
				aacPlayer.disableLoop();
				aacPlayer.enableRepeat();
			}
			else
			{
				setup.setRepstate(Repeatstate.REPEATLOOPOFF);
				mf.getBtnRepeatloop().setText("Loop off");
				aacPlayer.disableLoop();
				aacPlayer.disableRepeat();
			}
		}
	}
	
// ---------------------------------------------------

}