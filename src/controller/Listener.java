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

import gui.Mainframe;
import main.Main;
import model.FileHandler;
import model.PlayerFunctions;

public class Listener implements ActionListener
{

	Mainframe mf = Main.getMf();
	final JFileChooser fc = new JFileChooser();
	PlayerFunctions pf = new PlayerFunctions();
	FileHandler fileHandler = new FileHandler();
	List<File> filesListed;
	public String fileLocation;
	Path directoryName;
//	String chooserTitle;
	

//---------------------------------------------------		 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void actionPerformed(ActionEvent e)
	{

		Object source = e.getSource();
		Mainframe mf = Main.getMf();

//---------------------------------------------------		 
		if (source == mf.getMntmOpen())
		{
			directoryName = fileHandler.chooseDirectory();	
			
			filesListed = fileHandler.listf(directoryName.toString());
			
			DefaultListModel listModel = new DefaultListModel();
			mf.setMediaList(new JList(listModel));
			for(int i = 0; i < filesListed.size(); i++)
			{
				listModel.addElement(filesListed.get(i));
			}
			mf.getMediaList().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			JScrollPane scrollPane = new JScrollPane(mf.getMediaList());
			scrollPane.setBounds(10, 10, 937, 583);
			mf.getMainPanel().add(scrollPane);
			scrollPane.setViewportView(mf.getMediaList());
			
			mf.getMediaList().repaint();
			
//		    FileFilter filter = new FileNameExtensionFilter("MP3 Files", "m4a", "mp3", "wav", "aac", "flac");
		}
		
//---------------------------------------------------		 
		if (source == mf.getBtnStartPause())
		{
			
			if(pf.getIsplaying() == false)
			{
				pf.playAudio();
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
//---------------------------------------------------		 


}
