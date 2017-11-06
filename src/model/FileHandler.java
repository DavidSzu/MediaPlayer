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
	FileFilter filter = new FileNameExtensionFilter("Music Files", new String[] {"m4a", "mp3", "wav", "flac"});

// ---------------------------------------------------
	public Path chooseDirectory()
	{
		Path path = null;
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setFileFilter(filter);
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
	public ArrayList<File> listf(String directoryName)
	{
		File directory = new File(directoryName);
		File[] fList = directory.listFiles();

		ArrayList<File> resultList = new ArrayList<File>();
		for (File file : fList)
		{
			if (file.isFile())
			{
				resultList.add(file);
				System.out.println(file.getAbsolutePath() + " isFile");
			}
			else if (file.isDirectory())
			{
				listf(file.getAbsolutePath());
//				resultList.addAll(listf(file.getAbsolutePath()));
			}
		}
		System.out.println(fList + " fList");
		System.out.println(resultList + " resultlist");
		return resultList;
	}

// ---------------------------------------------------
	public List<String> listNames(String directoryName)
	{
		File directory = new File(directoryName);
		ArrayList<String> nameList = new ArrayList<String>();

		File[] fList = directory.listFiles();
		for(int i = 0; i < fList.length; i++)
		{
			String fileString = fList[i].toString();
			nameList.add(fileString);
//			System.out.println(nameList.get(i) + " nameList (" + i + ")");
		}
		return nameList;
	}
}