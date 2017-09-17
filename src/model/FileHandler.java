package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import javax.swing.JFileChooser;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

import gui.Mainframe;
import main.Main;

public class FileHandler
{
	Mainframe mf = Main.getMf();
	IOFileFilter filter = new RegexFileFilter("^(.*?)");
	

//---------------------------------------------------		
	public Path chooseDirectory()
	{
		Path path = null;
		JFileChooser chooser = new JFileChooser();
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
	public Collection<File> listFiles(String directoryName)
	{
		File directory = new File(directoryName);
		
		Collection<File> cfiles = FileUtils.listFiles(directory, filter, null);

////get all the files from a directory
//		File[] fList = directory.listFiles();
//		for(File file : fList)	
//		{
//			if(file.isFile())
//			{
//				files.add(file);
//			}
//			else if(file.isDirectory())
//			{
//				listFiles(file.getAbsolutePath(), files);
//			}
//		}
		return cfiles;
	}
	
//---------------------------------------------------
	public List<String> getFileNames(List<String> fileNames, Path dir)
	{
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir))
		{
			for (Path path : stream)
			{
				if(path.toFile().isDirectory())
				{
					getFileNames(fileNames, path);
				}
				else
				{
					fileNames.add(path.toAbsolutePath().toString());
					System.out.println(path.getFileName());
				}
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return fileNames;
	}
}