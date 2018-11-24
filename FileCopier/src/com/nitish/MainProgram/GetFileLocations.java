package com.nitish.MainProgram;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nitish.DataStorage.DataStore;

public class GetFileLocations {
	
	private String seperateFilePattern = "['.'].*";
	
	//Recursive function that gets all the folder directories
	//as well as the sub directories
	public void getAllFileLocation(File Sourcefile) {
			for(File l : Sourcefile.listFiles())
			{
					if(!MatchFiles(l.getPath()))
					{
						System.out.println(l.getPath());
						DataStore.filePaths.add(l.getPath());
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
