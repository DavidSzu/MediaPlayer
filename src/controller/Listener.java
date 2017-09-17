package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
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
	Collection<File> filesListed;
	List<String> filesListed2;
	List<File> filesListed3;
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
//			
//			filesListed = fileHandler.listFiles(directoryName, filesListed);
//			fileListed = fileHandler.getFileNames(fileListed, directoryName);
			
			filesListed3 = fileHandler.listf(directoryName.toString());
			
			DefaultListModel listModel = new DefaultListModel();
			mf.setMediaList(new JList(listModel));
			for(int i = 0; i < filesListed3.size(); i++)
			{
				listModel.addElement(filesListed3.get(i));
			}
			mf.getMediaList().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			JScrollPane scrollPane = new JScrollPane(mf.getMediaList());
			scrollPane.setBounds(10, 10, 937, 583);
			mf.getMainPanel().add(scrollPane);
			scrollPane.setViewportView(mf.getMediaList());
			
			mf.getMediaList().repaint();
//			
//		    FileFilter filter = new FileNameExtensionFilter("MP3 Files", "m4a", "mp3", "wav", "aac", "flac");
//		    JFileChooser chooser = new JFileChooser("D:\\Music");
//		    chooser.addChoosableFileFilter(filter);
////		    
//		    int returnVal = chooser.showSaveDialog(null);
////		    
//		    if(returnVal == JFileChooser.APPROVE_OPTION)
//		    {
//		    	File myFile = chooser.getSelectedFile();
//		    	String song = myFile + "";
//		    	
//		    	pf.playAudio(song);
//		    	String name = chooser.getSelectedFile().getName();
//		    }
		}
		
//---------------------------------------------------		 
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
	
//	public Collection<File> getfilesListed()
//	{
//		return fileListed;
//	}
}
