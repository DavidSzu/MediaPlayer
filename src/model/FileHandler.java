package model;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileHandler
{

	public static List<String> readFile(String path, Charset encoding) throws IOException
	{
		List<String> lines = Files.readAllLines(Paths.get(path), encoding);
		return lines;
	}

//	public void listDir(File dir)
//	{
//		File[] files = dir.listFiles();
//		if (files != null)
//		{
//			for (int i = 0; i < files.length; i++)
//			{
//				System.out.println(files[i].getAbsolutePath());
//				if (files[i].isDirectory())
//				{
//					System.out.println(" (Ordner)\n");
//				}
//				else
//				{
//					System.out.println(" (Datei)\n");
//				}
//			}
//		}
//	}

	// URI uri = ListAllLines.class.getResource(")
	// String path = "/Users/DSzustkowski/Documents/Music";
	//

	// static String readFile(String path, Charset encoding) throws IOException
	// {
	// byte[] encoded = Files.readAllBytes(Paths.get(path));
	// return new String(encoded, encoding);
	// }
	// File folder = new File("/Users/DSzustkowski/Documents/Music");
	// File[] listOfFiles = folder.listFiles();
	// {
	//
	// for (File file : listOfFiles)
	// {
	// if (file.isFile())
	// {
	// System.out.println(file.getName());
	// }
	// }
	// }

	// public void listFilesForFolder(final File folder)
	// {
	// for(final File fileEntry : folder.listFiles())
	// {
	// if(fileEntry.isDirectory())
	// {
	// listFilesForFolder(fileEntry);
	// }
	// else
	// {
	// System.out.println(fileEntry.getName());
	// }
	// }
	// }
	//
	// try(Stream<Path> paths =
	// Files.walk(Paths.get("/Users/DSzustkowski/Documents/Music")))
	// {
	// paths
	// .filter(Files::isRegularFile)
	// .forEach(System.out.println);
	// }

}