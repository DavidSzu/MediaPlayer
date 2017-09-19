package model;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.Mainframe;
import main.Main;

public class FileHandler
{
	Mainframe mf = Main.getMf();
	FileFilter filter = new FileNameExtensionFilter("Music Files", new String[]{"m4a", "mp3", "wav"});
	
	

//---------------------------------------------------		
	public Path chooseDirectory()
	{
		Path path = null;
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.showOpenDialog(mf);			
		System.out.println("current Directory:" + chooser.getCurrentDirectory());
		
		if(chooser.getCurrentDirectory().isDirectory())
		{
			path = Paths.get(chooser.getCurrentDirectory().getAbsolutePath());
			return path;
		}
		else if(chooser.getCurrentDirectory().isFile())
		{
			path = Paths.get(chooser.getSelectedFile().getPath());
			return path;
		}
		return path;
	}
	
//---------------------------------------------------				
	public List<File> listf(String directoryName)
	{
		File directory = new File(directoryName);
		
		List<File> resultList = new ArrayList<File>();
		
		File[] fList = directory.listFiles();
		resultList.addAll(Arrays.asList(fList));
		for(File file : fList)
		{
			if (file.isFile())
			{
				System.out.println(file.getAbsolutePath() + " isFile");
			}
			else if(file.isDirectory())
			{
				resultList.addAll(listf(file.getAbsolutePath()));
				System.out.println(file.getAbsolutePath() + " isDir");
			}
		}
		System.out.println(fList);
		return resultList;
	}
	
//---------------------------------------------------				
	
}