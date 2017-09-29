package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    FileFilter filter = new FileNameExtensionFilter("MP3 Files", "m4a", "mp3", "wav", "aac", "flac");
	

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
		}
		
//---------------------------------------------------		 
		if (source == mf.getBtnStartPause())
		{
			
			if(pf.getIsplaying() == false)
			{
				//ToDo
//				URL soundURL = Listener.class.getResource("/src/resources/Mission.m4a");
//				pf.playAudio();
				try
				{
					pf.playAudio(new File(mf.getMediaList().getSelectedValue().getAbsoluteFile().getPath()).toURI().toURL());
				}
				catch (MalformedURLException e1)
				{
					e1.printStackTrace();
				}
				
				pf.setIsplaying(true);
				mf.getBtnStartPause().setText("Pause");
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
