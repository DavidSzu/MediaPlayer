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
				return name.toLowerCase().endsWith("m4a");
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
				System.out.println(file.getAbsolutePath() + " isFile");
			}
			else if (file.isDirectory())
			{
				listf(file.getAbsolutePath());
			}

		}
		System.out.println(mediaPlayerModel.getFileList() + " mediaPlayerModel.getFileList");

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