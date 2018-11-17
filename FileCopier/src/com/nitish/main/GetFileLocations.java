package com.nitish.main;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nitish.DataStorage.DataStore;

public class GetFileLocations {
	
	private String seperateFilePattern = "['.'].*";
	private String destination;
	public GetFileLocations(String destination) {
		this.destination = destination;
	}
	//Recursive function that gets all the folder directories
	//as well as the sub directories
	public void getAllFileLocation(File Sourcefile) {
			for(File l : Sourcefile.listFiles())
			{
					if(!MatchFiles(l.getPath()))
					{
						DataStore.FilePaths.add(l.getPath());
					}
					try
					{
						getAllFileLocation(l);
					}
					catch(NullPointerException NulptrExc)
					{
						continue;
					}
			}
	}
	private boolean MatchFiles(String StringToCheck) 
	{
		boolean isMatched = true;
		Pattern pattern = Pattern.compile(seperateFilePattern);
		Matcher matcher = pattern.matcher(StringToCheck);
		if(matcher.find()) {
			isMatched = false;
		}
		return isMatched;	
	}
}
