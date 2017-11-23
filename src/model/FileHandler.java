package model;

import gui.Mainframe;
import main.Main;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHandler
{
	Mainframe mf = Main.getMf();
	MediaPlayerModel mediaPlayerModel = Main.getMediaPlayerModel();
	FileFilter filter = new FileNameExtensionFilter("MP3 Files", "m4a", "mp3", "wav", "aac", "flac");

	// ---------------------------------------------------
	public Path chooseDirectory()
	{
		Path path = null;
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.showOpenDialog(mf);
		System.out.println("current Directory:" + chooser.getCurrentDirectory());

		if (chooser.getCurrentDirectory().isDirectory())
		{
			path = Paths.get(chooser.getCurrentDirectory().getAbsolutePath());
			return path;
		}
		else if (chooser.getCurrentDirectory().isFile())
		{
			path = Paths.get(chooser.getSelectedFile().getPath());
			return path;
		}
		return path;
	}

	// ---------------------------------------------------
	public void listf(String directoryName)
	{
		File directory = new File(directoryName);
		File[] fList = directory.listFiles(new ExtensionFileFilter("MP3 Files", "m4a", "mp3", "wav", "aac", "flac")
		{
			
			@Override
			public boolean accept(File dir, String name)
			{
<<<<<<< HEAD
				if(name.toLowerCase().endsWith("m4a"))
				{
					mediaPlayerModel.setFileExtension("m4a");
					return name.toLowerCase().endsWith("m4a");
				}
				else if(name.toLowerCase().endsWith("mp3"))
				{
					mediaPlayerModel.setFileExtension("mp3");
					return name.toLowerCase().endsWith("mp3");
				}
				else if(name.toLowerCase().endsWith("wav"))
				{
					mediaPlayerModel.setFileExtension("wav");
					return name.toLowerCase().endsWith("wav");
				}
				else if(name.toLowerCase().endsWith("aac"))
				{
					mediaPlayerModel.setFileExtension("aac");
					return name.toLowerCase().endsWith("aac");
				}
				else if(name.toLowerCase().endsWith("flac"))
				{
					mediaPlayerModel.setFileExtension("flac");
					return name.toLowerCase().endsWith("flac");
				}
				else return false;
=======
//				if(name.toLowerCase().endsWith("m4a"))
//				{
					return name.toLowerCase().endsWith("m4a");
//				}
//				else if(name.toLowerCase().endsWith("mp3"))
//				{
//					return name.toLowerCase().endsWith("mp3");
//				}
//				else if(name.toLowerCase().endsWith("wav"))
//				{
//					return name.toLowerCase().endsWith("wav");
//				}
//				else if(name.toLowerCase().endsWith("aac"))
//				{
//					return name.toLowerCase().endsWith("aac");
//				}
//				else if(name.toLowerCase().endsWith("flac"))
//				{
//					return name.toLowerCase().endsWith("flac");
//				}
//				else return false;
>>>>>>> 639d6baa503ab192f24719130aae8d2d4c6fa771
			}
		});
		
		ArrayList<File> filesListed = mediaPlayerModel.getFileList();
		ArrayList<URL> fileURLs = mediaPlayerModel.getUrlList();

		for (File file : fList)
		{
			if (file.isFile())
			{
				filesListed.add(file);
				try
				{
					fileURLs.add(file.toURI().toURL());
				}
				catch (MalformedURLException e)
				{
					e.printStackTrace();
				}
			}
			else if (file.isDirectory())
			{
				listf(file.getAbsolutePath());
			}
		}
	}

	// ---------------------------------------------------
	public void listNames(String directoryName)
	{
		File directory = new File(directoryName);
		ArrayList<String> nameList = mediaPlayerModel.getNameList();

		File[] fList = directory.listFiles();
		for (int i = 0; i < fList.length; i++)
		{
			String fileString = fList[i].toString();
			nameList.add(fileString);
			// System.out.println(nameList.get(i) + " nameList (" + i + ")");
		}
	}
}