package model;


public class Song
{
	private String filepath;
	private String titel;
	private String artist;
	private String displayname;
	
	
    public Song(String path) 
    {
	this.filepath = path + "";
    }

    public String getfilepath() {
	return this.filepath;
    }
}
